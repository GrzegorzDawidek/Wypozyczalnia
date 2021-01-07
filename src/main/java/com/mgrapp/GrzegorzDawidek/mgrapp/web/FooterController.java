package com.mgrapp.GrzegorzDawidek.mgrapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {

    @GetMapping("/aboutus")
    public void readAboutUs() {

    }

    @GetMapping("/faq")
    public void readFAQ() {

    }

    @GetMapping("/contact")
    public void readContact() {

    }

    @GetMapping("/author")
    public void readAuthor() {

    }

    @GetMapping("/Error403")
    public void readError403() {

    }
}
