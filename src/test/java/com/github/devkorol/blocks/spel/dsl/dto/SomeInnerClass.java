package com.github.devkorol.blocks.spel.dsl.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@Accessors(chain = true)
public class SomeInnerClass {

  private String product;
  private String inn;
}
