package com.ivangro.interfaces.defaultmethod;

/*
* This approach is related with the traditional reason Java never supported multiple inheritance,
* the so-called 'diamond problem'
*/
public interface Employee {

  String getFirstname();

  String getLastname();

  void convertCaffeineToCodeForMoney();

  default String getName() {
    return String.format("%s %s", getFirstname(), getLastname());
  }
}
