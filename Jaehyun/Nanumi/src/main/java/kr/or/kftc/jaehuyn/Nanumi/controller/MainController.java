package kr.or.kftc.jaehuyn.Nanumi.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
 
   @RequestMapping(value = { "/", "/board" }, method = RequestMethod.GET)
   public String welcomePage(Model model, Principal principal) {
       model.addAttribute("title", "Board");
       model.addAttribute("message", "This is Nanumi Board Page,");
       model.addAttribute("user", principal.getName());
       // After user login successfully.
       String userName = principal.getName();
       System.out.println("User Name: "+ userName);
       return "board";
   }
 
    
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String loginPage(Model model ) {
       return "loginPage";
   }
 
   /*@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(Model model) {
       model.addAttribute("title", "Logout");
       return "logoutSuccessfulPage";
   }*/
 
   @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
   public String userInfo(Model model, Principal principal) {
 
 
       return "userInfoPage";
   }
 
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
        
       if (principal != null) {
           model.addAttribute("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addAttribute("msg",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }
}
