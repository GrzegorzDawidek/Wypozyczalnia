package com.mgrapp.GrzegorzDawidek.mgrapp.web;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.Reservation;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.User;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.dto.ReserveArticleDto;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.ReservationRepository;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.UserRepository;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.ArticlesService;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.ReservationService;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("articles") Articles articles) {
        articlesService.save(articles);
        return "redirect:/newarticle";
    }

    @RequestMapping("/newarticle")
    public String newProduct(Model model) {
        Articles articles = new Articles();
        model.addAttribute("articles", articles);
        return "newarticle";
    }

    @RequestMapping(value = "/reservedarticle", method = RequestMethod.POST)
    public String saveDateReservation(@ModelAttribute("reservation") ReserveArticleDto reserveArticleDto, SecurityContextHolder securityContextHolder) {

        Object principal = securityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            User user = userRepository.findByEmail(username);

            boolean succcessfulReservation = reservationService.reserveArticle(reserveArticleDto, user);
            if (!succcessfulReservation) {
                return "bookingerror";
            }
        }
        return "bookingsuccess";
    }


    @RequestMapping("/reservedarticle")
    public String newProduct1(Model model) {
        List<Reservation> reservationList = reservationService.listAll();
        model.addAttribute("reservationList", reservationList);
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        List<User> listUsers = userServiceImpl.listAll();
        model.addAttribute("listUsers", listUsers);

        return "reservedarticle";
    }



    @RequestMapping("/rekawice")
    public String addItemSnowboard(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "rekawice";
    }

    @RequestMapping("/stroj")
    public String addItemSticks(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "stroj";
    }

    @RequestMapping("/pilka")
    public String addItemWintersuit(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "pilka";
    }




}
