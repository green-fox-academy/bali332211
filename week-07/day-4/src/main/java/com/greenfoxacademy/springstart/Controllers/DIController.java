package com.greenfoxacademy.springstart.Controllers;


import com.greenfoxacademy.springstart.StudentService.StudentService;
import com.greenfoxacademy.springstart.UtilityService.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DIController {

  private UtilityService utilityService;
  private StudentService studentService;

  @Autowired
  DIController(UtilityService utilityService, StudentService studentService) {
    this.utilityService = utilityService;
    this.studentService = studentService;
  }

  @GetMapping("/useful")
  public String use() {
    return "colors";
  }

  @GetMapping("/useful/colored")
  public String useColored(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @GetMapping("/useful/red")
  public String useRed() {
    return "red";
  }

  @GetMapping("/useful/blue")
  public String useBlue() {
    return "blue";
  }

  @GetMapping("/useful/yellow")
  public String useYellow() {
    return "yellow";
  }

  @GetMapping("/useful/email")
  public String useEmail(Model model, @RequestParam String email) {
    model.addAttribute("emailValidation", utilityService.validateEmail(email));
    if (utilityService.validateEmail(email).equalsIgnoreCase("this is valid email")) {
      return "validEmail";
    } else {
      return "invalidEmail";
    }
  }

  @GetMapping("/useful/encoded")
  public String useEncoded(Model model, @RequestParam String encoded, @RequestParam int number) {
    model.addAttribute("encoded", utilityService.caesar(encoded, number));
    return "encoded";
  }

  @GetMapping("/useful/decoded")
  public String useDecoded(Model model, @RequestParam String decoded, @RequestParam int number) {
    model.addAttribute("decoded", utilityService.caesar(decoded, number * (-1)));
    return "decoded";
  }

  @GetMapping("/useful/gfa")
  public String useGfa() {
    return "/gfa/gfa";
  }

  @GetMapping("/useful/gfa/students")
  public String useGfaStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "/gfa/students";
  }

  @GetMapping("/useful/gfa/add")
  public String useGfaAdd() {
    return "gfa/add";
  }

  @PostMapping("/useful/gfa/add")
  public String useGfaSave(@RequestParam String name) {
    studentService.save(name);
    return "redirect:/useful/gfa";
  }


}
