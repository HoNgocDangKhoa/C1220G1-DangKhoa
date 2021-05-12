package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {
    @GetMapping("/greeting")
//    public String greeting(@RequestParam String name, Model model) {
    public String greeting() {
//        model.addAttribute("namekhoa", name);
        return "index";
    }

    @PostMapping("/greeting")
    public String PostGreeting(@RequestParam String name, Model model) {
        model.addAttribute("namekhoa", name);
        return "index2";
    }
}

