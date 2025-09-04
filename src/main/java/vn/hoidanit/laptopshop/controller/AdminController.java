package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getCreatePage(Model model, @ModelAttribute("newUser") User syl1) {
        model.addAttribute("newUser", new User());
        if (syl1 != null) {
            System.out.println("User info: " + syl1.getEmail() + " - " + syl1.getFullName() + " - " + syl1.getPhone());
        }
        return "admin/user/create";
    }

}
