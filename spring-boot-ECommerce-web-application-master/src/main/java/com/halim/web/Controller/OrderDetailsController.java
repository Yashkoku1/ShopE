package com.halim.web.Controller;

import com.halim.dao.CartItemRepository;
import com.halim.dao.OrderRepository;
import com.halim.model.CartItem;
import com.halim.model.ShoppingCart;
import com.halim.web.service.OrderService;
import com.halim.web.service.ProductService;
import com.halim.web.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

@Controller
public class OrderDetailsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository repo;
    @Autowired
    private CartItemRepository repository;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private OrderService service;
//    @GetMapping("/order")
//    public String viewMyorder(HttpServletRequest request, Model model) {
//
//        return "Admin/MyOrder";
//    }

    @GetMapping({"/order"})
    public List<CartItem> getAllEmployees(Model model) {
        List<CartItem> listProducts=repository.findAll();
        model.addAttribute("orders", listProducts);
        return listProducts;
    }
//    @ModelAttribute
//    public void populateModel(Model model, HttpServletRequest request) {
//        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
//
//    //    model.addAttribute("categories",productService.getAllCategories());
//
//        model.addAttribute("orders",repo.findAll());
//       // model.addAttribute("featured",productService.getProductWithBigestDiscount());
//    }
}
