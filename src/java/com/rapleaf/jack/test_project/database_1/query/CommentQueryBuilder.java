package com.rapleaf.jack.test_project.database_1.query;

import java.util.Set;

import com.rapleaf.jack.AbstractQueryBuilder;
import com.rapleaf.jack.FieldSelector;
import com.rapleaf.jack.IQueryOperator;
import com.rapleaf.jack.JackMatchers;
import com.rapleaf.jack.WhereConstraint;
import com.rapleaf.jack.QueryOrder;
import com.rapleaf.jack.OrderCriterion;
import com.rapleaf.jack.LimitCriterion;
import com.rapleaf.jack.test_project.database_1.iface.ICommentPersistence;
import com.rapleaf.jack.test_project.database_1.models.Comment;


public class CommentQueryBuilder extends AbstractQueryBuilder<Comment> {

  public CommentQueryBuilder(ICommentPersistence caller) {
    super(caller);
  }

  public CommentQueryBuilder id(Long value) {
    addId(value);
    return this;
  }

  public CommentQueryBuilder id(Set<Long> values) {
    addIds(values);
    return this;
  }

  public CommentQueryBuilder limit(int offset, int nResults) {
    setLimit(new LimitCriterion(offset, nResults));
    return this;
  }

  public CommentQueryBuilder limit(int nResults) {
    setLimit(new LimitCriterion(nResults));
    return this;
  }

  public CommentQueryBuilder select(Comment._Fields... fields) {
    for (Comment._Fields field : fields){
      addSelectedField(new FieldSelector(field));
    }
    return this;
  }

  public CommentQueryBuilder selectAgg(FieldSelector... aggregatedFields) {
    addSelectedFields(aggregatedFields);
    return this;
  }

  public CommentQueryBuilder groupBy(Comment._Fields... fields) {
    addGroupByFields(fields);
    return this;
  }

  public CommentQueryBuilder order() {
    this.addOrder(new OrderCriterion(null, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder order(QueryOrder queryOrder) {
    this.addOrder(new OrderCriterion(null, queryOrder));
    return this;
  }
  
  public CommentQueryBuilder orderById() {
    this.addOrder(new OrderCriterion(null, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder orderById(QueryOrder queryOrder) {    
    this.addOrder(new OrderCriterion(null, queryOrder));
    return this;
  }

  public CommentQueryBuilder content(String value) {
    if(value == null) {
      addConstraint(new WhereConstraint<String>(Comment._Fields.content, JackMatchers.<String>isNull()));
    }
    else {
      addConstraint(new WhereConstraint<String>(Comment._Fields.content, JackMatchers.equalTo(value)));
    }
    return this;
  }

  public CommentQueryBuilder content(IQueryOperator<String> operator) {
    addConstraint(new WhereConstraint<String>(Comment._Fields.content, operator));
    return this;
  }
  
  public CommentQueryBuilder orderByContent() {
    this.addOrder(new OrderCriterion(Comment._Fields.content, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder orderByContent(QueryOrder queryOrder) {
    this.addOrder(new OrderCriterion(Comment._Fields.content, queryOrder));
    return this;
  }

  public CommentQueryBuilder commenterId(Integer value) {
    if(value == null) {
      addConstraint(new WhereConstraint<Integer>(Comment._Fields.commenter_id, JackMatchers.<Integer>isNull()));
    }
    else {
      addConstraint(new WhereConstraint<Integer>(Comment._Fields.commenter_id, JackMatchers.equalTo(value)));
    }
    return this;
  }

  public CommentQueryBuilder commenterId(IQueryOperator<Integer> operator) {
    addConstraint(new WhereConstraint<Integer>(Comment._Fields.commenter_id, operator));
    return this;
  }
  
  public CommentQueryBuilder orderByCommenterId() {
    this.addOrder(new OrderCriterion(Comment._Fields.commenter_id, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder orderByCommenterId(QueryOrder queryOrder) {
    this.addOrder(new OrderCriterion(Comment._Fields.commenter_id, queryOrder));
    return this;
  }

  public CommentQueryBuilder commentedOnId(Long value) {
    if(value == null) {
      addConstraint(new WhereConstraint<Long>(Comment._Fields.commented_on_id, JackMatchers.<Long>isNull()));
    }
    else {
      addConstraint(new WhereConstraint<Long>(Comment._Fields.commented_on_id, JackMatchers.equalTo(value)));
    }
    return this;
  }

  public CommentQueryBuilder commentedOnId(IQueryOperator<Long> operator) {
    addConstraint(new WhereConstraint<Long>(Comment._Fields.commented_on_id, operator));
    return this;
  }
  
  public CommentQueryBuilder orderByCommentedOnId() {
    this.addOrder(new OrderCriterion(Comment._Fields.commented_on_id, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder orderByCommentedOnId(QueryOrder queryOrder) {
    this.addOrder(new OrderCriterion(Comment._Fields.commented_on_id, queryOrder));
    return this;
  }

  public CommentQueryBuilder createdAt(Long value) {
    if(value == null) {
      addConstraint(new WhereConstraint<Long>(Comment._Fields.created_at, JackMatchers.<Long>isNull()));
    }
    else {
      addConstraint(new WhereConstraint<Long>(Comment._Fields.created_at, JackMatchers.equalTo(value)));
    }
    return this;
  }

  public CommentQueryBuilder createdAt(IQueryOperator<Long> operator) {
    addConstraint(new WhereConstraint<Long>(Comment._Fields.created_at, operator));
    return this;
  }
  
  public CommentQueryBuilder orderByCreatedAt() {
    this.addOrder(new OrderCriterion(Comment._Fields.created_at, QueryOrder.ASC));
    return this;
  }
  
  public CommentQueryBuilder orderByCreatedAt(QueryOrder queryOrder) {
    this.addOrder(new OrderCriterion(Comment._Fields.created_at, queryOrder));
    return this;
  }
}
