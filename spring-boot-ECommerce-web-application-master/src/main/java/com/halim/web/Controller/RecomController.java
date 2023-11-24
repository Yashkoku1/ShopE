//package com.halim.web.Controller;
//
//import com.halim.model.User;
//import com.halim.web.service.RecomService;
//import com.halim.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class RecomController {
//    @Autowired
//    RecomService service;
//    @Autowired
//    UserService userService;
//    @GetMapping("/getDetails")
//    public void getProduct(HttpServletRequest request){
//       // User authuser=userService.login(email,password);
//        String authuser=null;
//        request.getSession().getAttribute("authuser",authuser);
//
//        service.getRecommenProduct();
//    }
//}
