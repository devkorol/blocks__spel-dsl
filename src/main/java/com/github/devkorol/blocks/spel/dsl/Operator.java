package com.github.devkorol.blocks.spel.dsl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Operator {
  LE("<="),
  LT("<"),
  EQ("=="),
  QT(">"),
  QE(">=");

  private final String payload;


  @Override
  public String toString() {
    return this.payload;
  }
}
