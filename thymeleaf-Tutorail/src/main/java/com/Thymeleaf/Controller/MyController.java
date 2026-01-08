package com.Thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    //http://localhost:8080/about

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(Model model){
        System.out.println("Inside about Handler...");

        //putting data in Model....
        model.addAttribute("name","Md arman");
        model.addAttribute("currentDate",new Date().toLocaleString());


        return "about";
        //about.html

    }

    //Handling iteration....
    @GetMapping("/example-loop")
    public String iterateHandler(Model m){
        //send
        //create a list,collection...
        List<String> names=List.of("Ankit","Laxmi","Karan","John");
        m.addAttribute("names",names);
        return "iterate";
    }

    //Handler for conditional statements....
    @GetMapping("/condition")
    public String conditionalHandler(Model m1){
        System.out.println("conditional handler is executed....");
        m1.addAttribute("isActive",false);
        m1.addAttribute("gender","F");

        List<Integer> list=List.of(12,87,32,10,70,23,15);
        m1.addAttribute("mylist",list);

        return "condition";
    }
    //handler for including Fragments....
    @GetMapping("/service")
    public String serviceHandler(Model m2){

        m2.addAttribute("title","I like to eat samosa");
        m2.addAttribute("subtitle", LocalDateTime.now().toString());
        return "service";
    }

    //for new about
    @GetMapping("/newabout")
    public String newAbout(){
        return "aboutnew";
    }
    //for new contact
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
