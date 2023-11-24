package com.halim.web.Controller;

import com.halim.dao.ShoppingCartRepository;
import com.halim.dao.UserRepository;
import com.halim.model.CartItem;
import com.halim.model.User;
import com.halim.spring.HttpURLPostRequest;
import com.halim.web.service.ShoppingCartService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PaymentController {
    @Autowired
    UserRepository repo;
@Autowired
    ShoppingCartRepository repository;
    @Autowired
    ShoppingCartService service;
    @GetMapping("/payprocess")
    public String showForm() {
        return "Admin/Payment";
    }

    @RequestMapping(value="/do-stuff")
    public String doStuffMethod() {
        return "Admin/Payment";
    }
    @PostMapping("/paymentpro")
    public String Dopay(@RequestParam("name")String name,
                        @RequestParam("email")String email,
                        @RequestParam("gendar")String gendar,
                        @RequestParam("pay")String amount,
                        @RequestParam("cnumber")String cnumber,
                        @RequestParam("cvc")String cvv,
                        @RequestParam("age")String age, HttpServletRequest session)
    {
        System.out.println("In payment method");
        System.out.println(name+" "+ email+" "+gendar);

//        User us=new User();
//        int trans=us.getTrans_limit();
//        User ab= (User) session.getSession(true).getAttribute("authuser");
//        String ab1=session.
//        long limit= ab.getTrans_limit();
//        String date=repository.findByDate()
////        return "redirect:shoppingCart";
////        int trans= repo.findBytrans();
////        CartItem crt=new CartItem();
//      System.out.println(limit);
//
//        if(Integer.parseInt(amount)>limit)
//        {
//
//            System.out.println("fraud");
//
//        }

//    HttpURLPostRequest hp=new HttpURLPostRequest();
//    //hp.sendPost(name,email,gendar,pay,cnumber,cvc);
//     JSONObject jsonObject= hp.sendVerifyPost(name,age,gendar,amount,cnumber,cvv);
//     if(jsonObject.has("success"))
//     {
//         //credit card details are genuine
//         System.out.println("Credit card detected as genuine");
//       return "redirect:/shoppingCart";
//     }
//     else
//     {
//         //credit card fraud detected. display related message
//         System.out.println("Credit card fraud detected");
//         return "redirect:/payprocess";
//     }
//


       return "";
    }

}
