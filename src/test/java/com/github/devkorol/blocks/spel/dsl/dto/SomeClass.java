package com.github.devkorol.blocks.spel.dsl.dto;

import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@Accessors(chain = true)
public class SomeClass {

  private String name;
  private String product;
  private String[] someArray;
  private Collection<String> someCollection;
  private SomeInnerClass inner;
  private List<SomeInnerClass> innerCollection;
}
