package com.greenfoxacademy.springstart.controllers;


import com.greenfoxacademy.springstart.models.User;
import com.greenfoxacademy.springstart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/xcys")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String register(@ModelAttribute(value = "userNew") User userNew,
                         @ModelAttribute(value = "userLogin") User userLogin,
                         HttpSession session) {

    if (session.getAttribute("userTaken") != null) {
      User userTaken = (User) session.getAttribute("userTaken");
      userNew.setUsername(userTaken.getUsername());
      userNew.setPassword(userTaken.getPassword());
      session.removeAttribute("userTaken");
    }
    return "register";
  }

  @PostMapping("/register")
  public String url(@ModelAttribute("userNew") User userNew,
                    RedirectAttributes redirectAttributes,
                    HttpSession session) {

    if (!userService.isUsernameAllowed(userNew.getUsername())) {
      redirectAttributes.addFlashAttribute("usernameTaken", true);
      session.setAttribute("userTaken", userNew);
      return "redirect:/xcys/register";
    }
    redirectAttributes.addFlashAttribute("usernameTaken", false);
    userService.addUser(userNew);
    session.setAttribute("userCurrent", userNew);
    return "redirect:/xcys";
  }

  @GetMapping("/deleteUsers")
  public String deleteUsers() {
    userService.deleteAllUsers();
    return "redirect:/xcys/register";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute(value = "userLogin") User userLogin,
                      HttpSession session,
                      RedirectAttributes redirectAttributes) {
    if (!userService.userFound(userLogin)) {
      redirectAttributes.addFlashAttribute("userNotFound", true);
//            redirectAttributes.addFlashAttribute("passwordIncorrect", true);
      return "redirect:/xcys/register";
    }
    session.setAttribute("userCurrent", userService.getUserByUsername(userLogin.getUsername()));
    return "redirect:/xcys";
  }

}
