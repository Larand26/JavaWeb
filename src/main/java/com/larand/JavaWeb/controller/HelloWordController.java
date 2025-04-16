package com.larand.JavaWeb.controller;

import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larand.JavaWeb.model.Pessoa;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {
    @PostMapping
    public Map<String, Object> sayHello(@RequestBody Pessoa pessoa) {
        Map<String, Object> response = new HashMap<>();
        response.put("nome", pessoa.getNome());
        response.put("idade", pessoa.getIdade());
        response.put("status", "success");
        return response;
    }
}
