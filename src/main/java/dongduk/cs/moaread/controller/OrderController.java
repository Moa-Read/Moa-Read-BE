package dongduk.cs.moaread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {

}
