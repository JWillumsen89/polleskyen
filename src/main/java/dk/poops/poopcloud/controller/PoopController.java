package dk.poops.poopcloud.controller;

import dk.poops.poopcloud.mail.MailSender;
import dk.poops.poopcloud.models.Wish;
import dk.poops.poopcloud.models.WishList;
import dk.poops.poopcloud.service.WishListService;
import dk.poops.poopcloud.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class PoopController {

    @Autowired
    MailSender mailSender;
    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;


    @GetMapping("/")
    public String index(Model model) {
       // model.addAttribute("wishlists", wishListService.fetchAllWishLists());
        return "index";
    }

    @GetMapping("/wishlists")
    public String showWishlistList(Model model) {
        model.addAttribute("wishlists", wishListService.fetchAllWishLists());
        return "wishlists";
    }

    @GetMapping("/showwishlist/{id}")
    public String showWishList(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("wishlist", wishListService.findWishListById(id));
        model.addAttribute("wish", wishService.fetchByID(id));


        return "showwishlist";
    }

    @GetMapping("/updatewishlist/{id}")
    public String updateWishlist(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("wishlist", wishListService.findWishListById(id));
        return "updatewishlist";
    }

    @GetMapping("/createwishlist")
    public String showCreateWishList() {
        return "createwishlist";
    }

    @PostMapping("/createwishlist")
    public String createWishlist(@ModelAttribute WishList wishList) {
        wishListService.saveWishList(wishList);

        return "redirect:/wishlists";
    }

    @PostMapping("/updatewishlist")
    public String saveWishlist(@ModelAttribute WishList wishList) {
        wishListService.saveWishList(wishList);
        return "redirect:/showwishlist/" + wishList.getId();
    }

    @GetMapping("/deletewishlist/{id}")
    public String deleteWishList(@PathVariable("id") int id) {
        wishListService.deleteWishList(id);
        return "redirect:/wishlists";
    }

    @GetMapping("/showwishlist/createwish/{id}")
    public String showWishCreateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("wishlist", wishListService.findWishListById(id));
        return "createwish";
    }

    @PostMapping("/showwishlist/createwish")
    public String createWish(@ModelAttribute Wish wish) {
        wishService.saveWish(wish);
        return "redirect:/showwishlist/" + wish.getList_id();
    }

    @GetMapping("deletewish/{id}/{wishid}")
    public String deleteWish(@PathVariable("wishid") int wishid, @PathVariable("id") int id) {
        wishService.deleteWish(wishid);
        return "redirect:/showwishlist/" + id;
    }

    @GetMapping("/showwishlist/sharewishlist/{id}")
    public String shareMailSite(@PathVariable("id") int wishListId, Model model) {
        model.addAttribute("wishlist", wishListService.findWishListById(wishListId));
        return "sharewishlist";
    }

    @GetMapping("/mail")
    public String mail(@RequestParam("mail") String mail, @RequestParam("wishList") String wishList, @RequestParam("link") String link) throws MessagingException {

        try {
            mailSender.send(mail, "Du har fået tilsendt ønskesedlen - " + wishList,
                    """  
                            Se ønskesedlen ved at klikke på dette link:""" + " " + link);

            return "mailsent";
        } catch (MailSendException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/mailtest")
    public String mailTest() {
        return "mailsent";
    }

    @GetMapping("/reservewish/{id}")
    public String reserveWish(@PathVariable("id") int id) {
        Wish wish = wishService.findById(id);
        wishService.reserveWish(wish);
        return "redirect:/showwishlist/" + wish.getList_id();
    }

}

