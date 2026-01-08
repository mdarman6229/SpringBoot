package com.Smart.Controller;

import com.Smart.Dao.UserRepository;
import com.Smart.Entities.Contact;
import com.Smart.Entities.User;
import com.Smart.helper.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test(){

        User user=new User();
        //user.setId(101);
        user.setName("Md Arman");
        user.setEmail("Mdarman959536@gmail.com");
        user.setAbout("Mechanical Engineer..");

        Contact contact=new Contact();
        user.getContacts().add(contact);

        userRepository.save(user);
        return "Working";
    }

    @RequestMapping("/")
    public String home(Model model){

        model.addAttribute("title","Home-Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){

        model.addAttribute("title","about-Smart Contact Manager");
        return "about";
    }
    @RequestMapping("/signup")
    public String signup(Model model){

        model.addAttribute("title","Register-Smart Contact Manager");
        model.addAttribute("user",new User());
        return "signup";


    }

    // Handler for registering order
    @RequestMapping(value = "do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement, Model model, HttpSession session) {

        try{

            if(!agreement){
                System.out.println("you have not agreed the terms and conditions");
                throw new Exception("you have not agreed the terms and conditions");
            }

            user.setRole("RLOE_USER");
            user.setEnabled(true);
            user.setImageUrl("default jpg");

            System.out.println("Agreement "+agreement);
            System.out.println("User "+user);

            User result=this.userRepository.save(user);

            model.addAttribute("user ",new User());

            session.setAttribute("message",new Message("Successful Registered!!","Alert-Success"));

            return "signup";

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user ",user);
            session.setAttribute("message",new Message("something went wrong!!"+e.getMessage(),"Alert danger"));

            return "signup";

        }





    }
}
