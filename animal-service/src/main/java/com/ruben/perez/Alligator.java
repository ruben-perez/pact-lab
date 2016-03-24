package com.ruben.perez;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by ruben.perez on 23/3/16.
 */
public class Alligator {

  private String name;

  public Alligator() {
  }

  public Alligator(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    Alligator rhs = (Alligator) obj;
    return new EqualsBuilder()
        .append(this.name, rhs.name)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(name)
        .toHashCode();
  }
}
