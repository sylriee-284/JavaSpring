package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println("User list: " + users);

        String email = "sylriee284@gmail.com";
        List<User> usersByEmail = this.userService.getUserByEmail(email);
        System.out.println("Users with email " + email + ": " + usersByEmail);

        String message = this.userService.handleHello();
        model.addAttribute("message", message);
        return "hello";
    }

    @GetMapping("/admin/user")
    public String getUserViewPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin/user/userView";
    }

    @GetMapping(value = "/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/userDetail";
    }

    @GetMapping(value = "/admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/userUpdate";
    }

    @PostMapping(value = "/admin/user/update")
    public String handleUserUpdate(@ModelAttribute("user") User updateUser, Model model) {
        model.addAttribute("user", updateUser);
        System.out.println("Updated user data: " + updateUser);
        User existUser = this.userService.getUserById(updateUser.getId());
        updateUser.setPassword(existUser.getPassword());
        this.userService.handleSaveUser(updateUser);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/admin/user/delete/{id}")
    public String getUserDeletePage(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("userId", user.getId());
        return "admin/user/userDelete";
    }

    @PostMapping(value = "/admin/user/delete/{id}")
    public String handleUserDelete(@PathVariable("id") Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/user";
    }

}
