package com.github.devkorol.blocks.spel.dsl.part;

import java.util.ArrayList;
import java.util.List;

public class SpelPath {

  private List<Object> objects = new ArrayList<>();

  public static SpelPath from(String name){
    SpelPath path = new SpelPath();
    path.objects.add(
        SpelField.field(name)
    );
    return path;
  }
}
