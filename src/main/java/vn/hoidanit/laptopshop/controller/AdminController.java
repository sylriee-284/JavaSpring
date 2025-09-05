package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.hoidanit.laptopshop.domain.User;

@Controller
public class AdminController {

    @GetMapping("/admin/user/create")
    public String showCreateForm(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String handleCreateUser(@ModelAttribute("newUser") User syl1, Model model) {
        if (syl1 != null) {
            System.out.println("User info: " + syl1.getEmail() + " - " + syl1.getFullName() + " - " + syl1.getPhone());
        }
        return "admin/user/create";
    }

}
