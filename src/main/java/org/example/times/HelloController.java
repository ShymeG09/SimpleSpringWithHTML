package org.example.times;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring!";
    }

    @RequestMapping("/time1")
    @ResponseBody
    public LocalTime time1() {
        return LocalTime.now();
    }

    @RequestMapping("/time2")
    @ResponseBody
    public String time2() {
        return LocalTime.now().toString();
    }

    private static final DateTimeFormatter FORMAT_DATY = DateTimeFormatter
            .ofPattern("EEEE, dd.MM.YYYY, 'hour' HH:mm:ss", new Locale("eng", "PL"));

    @RequestMapping(path = "/time3", produces = "text/plain")
    @ResponseBody
    public String time3() {
        return LocalDateTime.now().format(FORMAT_DATY);
    }

    // Bad practice:
    @RequestMapping(path = "/time4", produces = "text/html")
    @ResponseBody
    public String time4() {
        LocalDateTime dt = LocalDateTime.now();
        return String.format(
                "<html><body><h1>Time and date</h1>"
                        + "<p>The time is: <strong style='color:purple'>%s</strong></p>"
                        + "<p>Today is: <strong style='color:blue'>%s</strong></p>"
                        + "<p style='color: green'>%s</p>" + "</body></html>",
                dt.toLocalTime(), dt.toLocalDate(), dt.format(FORMAT_DATY));
    }

    @RequestMapping("/time5")
    public String time5(Model model) {
        LocalDateTime dt = LocalDateTime.now();
        model.addAttribute("time", dt);
        model.addAttribute("formatted_time", dt.format(FORMAT_DATY));
        return "show_time5.html";
    }

    @RequestMapping("/time6")
    public String time6(Model model) {
        LocalDateTime dt = LocalDateTime.now();
        model.addAttribute("dt", dt);
        return "show_time6.html";
    }

    @RequestMapping("/ping")
    public String ping(HttpServletRequest request, Model model) {

        String ip = request.getRemoteAddr();
        String host = request.getRemoteHost();
        System.out.println("Inquiry from address " + ip);

        model.addAttribute("clientInfo", Map.of("userAgent", request.getHeader("User-Agent"), "ip", ip, "host", host));
        return "ping.html";
    }

}
