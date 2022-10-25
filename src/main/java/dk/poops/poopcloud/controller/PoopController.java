package dk.poops.poopcloud.controller;

import dk.poops.poopcloud.models.WishList;
import dk.poops.poopcloud.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PoopController {

  @Autowired
  WishListService wishListService;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("wishlists", wishListService.fetchAllWishLists());
    return "index";
  }
  @GetMapping("/updatewishlist/{id}")
  public String updatewishlist(@PathVariable("id")int id, Model model) {
    model.addAttribute("id",id);
    return "updatewishlist";
  }

  @GetMapping("/createwishlist")
  public String showCreateWishList(){
    return "createwishlist";
  }

  @PostMapping("/createwishlist")
  public String createWislist(@ModelAttribute WishList wishList){
    wishListService.saveWishList(wishList);

    return "redirect:/";
  }




}
