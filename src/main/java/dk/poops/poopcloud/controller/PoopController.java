package dk.poops.poopcloud.controller;

import dk.poops.poopcloud.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoopController {

  @Autowired
  WishListService wishListService;

  @GetMapping("/")
  private String index(Model model){
    model.addAttribute("wishlists", wishListService.fetchAllWishLists());
    return "index";

  }
}
