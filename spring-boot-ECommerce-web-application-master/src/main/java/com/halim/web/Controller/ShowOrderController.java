package com.halim.web.Controller;

import com.halim.model.CartItem;
import com.halim.model.CartWithUser;
import com.halim.web.service.OrderService;
import com.halim.web.service.ProductService;
import com.halim.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ShowOrderController {
    UserService userService;
    ProductService productService;
    @Autowired
    OrderService service;
    @GetMapping("/vendor/index")
    public String display(Model model)
    {
        List<CartWithUser> items = service.getAll();
        model.addAttribute("items", items);
        return "Admin/Showorder";
    }
}
