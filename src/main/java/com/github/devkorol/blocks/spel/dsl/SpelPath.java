package com.github.devkorol.blocks.spel.dsl;

import lombok.RequiredArgsConstructor;

public class SpelPath {
  private static final String DELIMETER = "?.";

  private String path;

  public String get(){
    return path;
  }

  public static SpelPath from(String fieldName) {
    SpelPath path = new SpelPath();
    path.path = fieldName;
    return path;
  }

  public SpelPath join(String fieldName) {
    path += DELIMETER + fieldName;
    return this;
  }

  public SpelArray array() {
    return new SpelArray(this);
  }

  @RequiredArgsConstructor
  private class SpelArray{

    private final SpelPath spelPath;

    public SpelArray filter(String fieldName, Operator op, String valuse) {
      path += DELIMETER + fieldName;
      return this;
    }

    public SpelArray or(){

      return this;
    }

    public SpelArray and(){

      return this;
    }

    public SpelPath get(){
      return spelPath;
    }
  }

}
