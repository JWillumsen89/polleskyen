package dk.poops.poopcloud.controller;

import dk.poops.poopcloud.models.Wish;
import dk.poops.poopcloud.models.WishList;
import dk.poops.poopcloud.service.WishListService;
import dk.poops.poopcloud.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PoopController {

  @Autowired
  WishListService wishListService;
  @Autowired
  WishService wishService;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("wishlists", wishListService.fetchAllWishLists());
    return "index";
  }

  @GetMapping("/showwishlist/{id}")
  public String showWishList(@PathVariable("id")int id, Model model) {
    model.addAttribute("id",id);
    model.addAttribute("wishlist",wishListService.findWishListById(id));
    model.addAttribute("wish",wishService.fetchByID(id));
    return "showwishlist";
  }

  @GetMapping("/updatewishlist/{id}")
  public String updateWishlist(@PathVariable("id")int id, Model model) {
    model.addAttribute("id",id);
    model.addAttribute("wishlist",wishListService.findWishListById(id));
    return "updatewishlist";
  }

  @GetMapping("/createwishlist")
  public String showCreateWishList(){
    return "createwishlist";
  }

  @PostMapping("/createwishlist")
  public String createWishlist(@ModelAttribute WishList wishList){
    wishListService.saveWishList(wishList);

    return "redirect:/";
  }
  @PostMapping("/updatewishlist")
  public String saveWishlist(@ModelAttribute WishList wishList){
    wishListService.saveWishList(wishList);
    return "redirect:/showwishlist/" + wishList.getId();
  }

  @GetMapping("/deletewishlist/{id}")
  public String deleteWishList(@PathVariable("id")int id){
    wishListService.deleteWishList(id);
    return "redirect:/";
  }

  @GetMapping("/showwishlist/createwish/{id}")
  public String showWishCreateForm(@PathVariable("id")int id, Model model){
    model.addAttribute("wishlist",wishListService.findWishListById(id));
    return "createwish";
  }

  @PostMapping("/showwishlist/createwish")
  public String createWish(@ModelAttribute Wish wish){
    wishService.saveWish(wish);
    return "redirect:/showwishlist/" + wish.getList_id();
  }

}