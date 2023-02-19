package org.example.times;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/parameters")
public class ParametersController {

    @RequestMapping("/hi")
    @ResponseBody
    public String hi(String name) {
        return "Hi " + name;
    }

    @RequestMapping(path="/repeat", produces="text/plain;charset=utf-8")
    @ResponseBody
    public String repeat(
            @RequestParam(defaultValue="") String text,
            @RequestParam(name="n", defaultValue="1") int howMany) {
        return (text + "\n").repeat(howMany);
    }

}
