package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

@GetMapping("/user-id/{id}")
public String findUserById(@PathVariable int id) {

   String msg = "";
   
   if (id > 0 && id < 100) {
    msg = "You have entered valid ID";
   } else {
    msg = "You have entered invalid ID";
   }

   return msg;
}

@GetMapping("/user-name/{userName}")
public String findUserByName(@PathVariable String userName) {

   String msg = "";
   if (userName.length() > 3 && userName.length() < 15) {
    msg = "You have entered valid USERNAME";
   } else {
    msg = "You have entered invalid USERNAME";
   }
   return msg;
}

@GetMapping("/user-cpf/{cpf}")
public String findUserByCPF(@PathVariable String cpf) {

   String msg = "";
   if (isCPF(cpf)) {
    msg = "You have entered valid CPF";
   } else {
    msg = "You have entered invalid CPF";
   }
   return msg;

}

public boolean isCPF(String cpf) {
   return (cpf.length() > 3 && cpf.length() < 15);
}

}
