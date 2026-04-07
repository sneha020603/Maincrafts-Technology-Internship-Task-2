package com.sneha.contactform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @PostMapping("/contact")
    public String save(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        Contact c = new Contact();
        c.setName(name);
        c.setEmail(email);
        c.setMessage(message);

        repo.save(c);

        return "redirect:/";
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> getAll() {
        return repo.findAll();
    }
}