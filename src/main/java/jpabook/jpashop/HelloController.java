package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        //model에 데이터를 담아서 view에 넘길 수 있다.
        //key : data, data : hello!!!
        model.addAttribute("data", "commit!!");

        //return은 화면 이름임 hello.html
        return "hello";
    }
}
