package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping(value = "/")
//    public String homePage(Model model){
//        List<User> users = userService.allUsers();
//        model.addAttribute("list_users", )
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("listUser", users);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id, ModelAndView modelAndView) {
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        userService.edit(user);
        modelAndView.setViewName("redirect:/");// redirect перенаправляет на адресс "/"
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(ModelAndView modelAndView) {
        User user = new User();
        modelAndView.setViewName("addPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}")
    @Transactional
    public String deleteUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        userService.delete(user);
        return "redirect:/";
    }
}
