package dk.poops.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoopController {
  @GetMapping("/")
  private String index(){
    return "index";

  }
}
