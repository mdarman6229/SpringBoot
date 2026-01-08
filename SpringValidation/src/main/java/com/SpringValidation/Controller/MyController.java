package com.SpringValidation.Controller;

import com.SpringValidation.entities.loginData;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.transform.Result;

@Controller
public class MyController {

    @GetMapping("/form")
    public  String openForm(Model model){
        System.out.println("opening form");

        model.addAttribute("loginData",new loginData());

        return "form";
    }
    //handler form for process
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData") loginData loginData, BindingResult result ){

        if(result.hasErrors()){
            System.out.println(result);
            return "form";
        }

        System.out.println(loginData);
        return"success";
    }
}
