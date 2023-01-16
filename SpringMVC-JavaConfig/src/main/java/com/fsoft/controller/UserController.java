package com.fsoft.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import com.fsoft.entity.User;
import com.fsoft.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({ "currentUser" })
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * This method handles login GET requests. If users is already logged-in and
     * tries to goto login page again, will be redirected to list page.
     */
    @GetMapping("login")
    public String loginPage(Principal principal) {
        return principal == null ? "login" : "redirect:/";
    }

    @PostMapping("login")
    public void postLogin(Model model, HttpSession session) {
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
                .getContext().getAuthentication();

        validatePrinciple(authentication.getPrincipal());

        User loggedInUser = ((UserDetailsImpl) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUsername());
        session.setAttribute("userId", loggedInUser.getUsername());

    }

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserDetailsImpl)) {
            throw new IllegalArgumentException("Principal can not be null!");
        }
    }

    @GetMapping(value = "login/failed")
    public String loginError(Model model) {
        log.info("Login attempt failed");
        model.addAttribute("error", "true");
        return "login";
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     */
    @GetMapping("logout")
    public ModelAndView logoutPage(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();

        return new ModelAndView("login");
    }

}
