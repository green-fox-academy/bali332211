package com.greenfoxacademy.springstart;

import com.greenfoxacademy.springstart.Color.BlueColor;
import com.greenfoxacademy.springstart.Color.MyColor;
import com.greenfoxacademy.springstart.Color.RedColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringstartApplication implements CommandLineRunner {

  @Autowired
  MyColor color;

  public static void main(String[] args) {
    SpringApplication.run(SpringstartApplication.class, args);

  }

  @Override
  public void run(String... args) throws Exception {
    color.printColor();
//    redColor.printColor();
  }
}

