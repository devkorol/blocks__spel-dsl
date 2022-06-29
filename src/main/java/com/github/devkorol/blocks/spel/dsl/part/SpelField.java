package com.github.devkorol.blocks.spel.dsl.part;

public class SpelField {

  private static final String DELIMETR = "?.";
  private String name;

  public static SpelField field(String name) {
    SpelField field = new SpelField();
    field.name = name;
    return field;
  }

  public SpelField join(String name) {
    return field(name);
  }

  public String get() {
    return DELIMETR + name;
  }
}
