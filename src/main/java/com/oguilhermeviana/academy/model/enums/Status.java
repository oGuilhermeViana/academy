package com.oguilhermeviana.academy.model.enums;

public enum Status {
  ATIVO("Ativo"),
  INATIVO("Inativo"),
  TRANCADO("Trancado");

  private String status;

  private Status(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
