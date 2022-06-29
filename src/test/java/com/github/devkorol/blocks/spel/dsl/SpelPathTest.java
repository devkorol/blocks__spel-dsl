package com.github.devkorol.blocks.spel.dsl;

import static org.junit.jupiter.api.Assertions.*;

import com.github.devkorol.blocks.spel.dsl.dto.SomeClass.Fields;
import com.github.devkorol.blocks.spel.dsl.dto.SomeInnerClass;
import lombok.Data;
import org.junit.jupiter.api.Test;

@Data
class SpelPathTest {
  //inner.inn
  //innerCollection.?[#this.inn == 'my_inn2']
  //innerCollection.![#this.inn]
  //innerCollection.?[#this.inn == 'my_inn2'].![#this.inn]

  @Test
  void testSimple(){
    String path = SpelPath.from(Fields.name).get();
    assertEquals("name", path);
  }

  @Test
  void testInnerSimple(){
    String path = SpelPath.from(Fields.inner)
        .join(SomeInnerClass.Fields.inn)
        .get();
    assertEquals("inner?.inn", path);
  }

}