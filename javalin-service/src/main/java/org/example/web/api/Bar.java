package org.example.web.api;

public class Bar {

  private String name;
  private long value;

  public Bar(String name, long value) {
    this.name = name;
    this.value = value;
  }

  public Bar() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }
}
