package com.frontend.rest.models;

public class Greeter {

  public String welcome_message;

  public Greeter(String name, String title) {
    this.welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
  }

}
