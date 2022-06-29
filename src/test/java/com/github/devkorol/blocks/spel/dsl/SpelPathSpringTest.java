package com.github.devkorol.blocks.spel.dsl;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.devkorol.blocks.spel.dsl.dto.SomeClass;
import com.github.devkorol.blocks.spel.dsl.dto.SomeInnerClass;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

class SpelPathSpringTest {

  private StandardEvaluationContext context = new StandardEvaluationContext();
  private SpelExpressionParser parser = new SpelExpressionParser();

  //inner.inn
  //innerCollection.?[#this.inn == 'my_inn2']
  //innerCollection.![#this.inn]
  //innerCollection.?[#this.inn == 'my_inn2'].![#this.inn]

  @Test
  void testSimple() {
    String path = SpelPath.from(SomeClass.Fields.name).get();
    SomeClass sam = new SomeClass().setName("Sam");

    String name = get(path, sam);

    assertEquals("Sam", name);
  }

  @Test
  void testFilterMulti() {
    String path = "innerCollection.?[(#this.inn == '1' && #this.product == '1') || #this.inn == '2']";
    SomeClass some = new SomeClass().setInnerCollection(asList(
        new SomeInnerClass().setInn("2"),
        new SomeInnerClass().setInn("1").setProduct("1"),
        new SomeInnerClass().setInn("1").setProduct("2")
    ));

    List<SomeInnerClass> filtered = get(path, some);

    System.out.println(filtered);
  }

  @Test
  void testFilterInner() {
    String path = "innerCollection.?[#this.inn == '1'].![#this.product]";
    SomeClass some = new SomeClass().setInnerCollection(asList(
        new SomeInnerClass().setInn("1").setProduct("1"),
        new SomeInnerClass().setInn("1").setProduct("2")
    ));

    List<SomeInnerClass> filtered = get(path, some);

    System.out.println(filtered);
  }

  public <T> T get(String path, Object o) {
    Expression exp = parser.parseExpression(path);
    return (T) exp.getValue(context, o);
  }
}