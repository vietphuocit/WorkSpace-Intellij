package com.fsoft.controller;

import com.fsoft.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@SessionAttributes({"currentUser"})
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * This method handles login GET requests. If users is already logged-in and
     * tries to goto login page again, will be redirected to list page.
     */
    @GetMapping("signin")
    public String loginPage(Principal principal) {
        return principal == null ? "user/pages/signin" : "redirect:/";
    }

    @GetMapping("signup")
    public ModelAndView registerPage(Principal principal) {
        return principal == null
                ? new ModelAndView("user/pages/signup", "user", new User())
                : new ModelAndView("redirect:/user/signup");
    }

    @PostMapping("signup")
    @ResponseBody
    public ModelAndView register(User user) {

        return new ModelAndView("user/pages/signup");
    }

}
