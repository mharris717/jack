# Copyright 2011 Rapleaf
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FORBIDDEN_FIELD_NAMES = ["tbl", "id"]

class SchemaRbParser
  extend HashRegexHelpers

  def self.parse(schema_rb, ignored_tables = [])
    file_lines = File.read(schema_rb).split("\n")
    file_lines.reject{|l| l =~ /^\s*$/}

    models = []
    migration_number = nil

    until file_lines.empty?
      line = file_lines.shift
      if line =~ /ActiveRecord::Schema.define/
        migration_number = extract_numeric_hash_value(line, :version)
      elsif line =~ /create_table/ && line !~ /schema_info/
        model_defn = ModelDefn.new(line, migration_number)
        next if ignored_tables.include?(model_defn.table_name)

        ordinal = 0
        line = file_lines.shift
        while line =~ /^\s*t\.[a-z]+ / && !file_lines.empty?
          matches = line.match(/^\s*t\.([a-z]+)\s*"([^"]+)",?(.*)$/)
          raise "problem with #{model_defn.table_name}" if !matches
          field_name = matches[2]
          unless FORBIDDEN_FIELD_NAMES.include?(field_name)
            field_defn = FieldDefn.new(
                field_name,
                matches[1].to_sym,
                ordinal,
                FieldDefn.parse_option_fields(matches[3])
            )

            model_defn.fields << field_defn
            ordinal += 1
          end
          line = file_lines.shift
        end
        models << model_defn
      end
    end
    return models, migration_number
  end
end

if $0 == __FILE__
  puts SchemaRbParser.parse(ARGV[0]).inspect
end
