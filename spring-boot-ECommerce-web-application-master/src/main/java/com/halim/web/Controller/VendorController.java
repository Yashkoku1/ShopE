//package com.halim.web.Controller;
//
//import com.halim.web.service.VendorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/Vendor")
//public class VendorController {
//    @Autowired
//    VendorService service;
//    @GetMapping("/vendorregister")
//    public String addvendor() {
//        return "Admin/vendorRegister";
//    }
//
//    @PostMapping("/vendorRegister")
//    public  String regvendor(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("mobile")long mobile,@RequestParam("psw")String psw,@RequestParam("psw_repeat")String pswr)
//    {
//        service.saveTo(name,email,mobile,psw,pswr);
//        return "Admin/vendorRegister";
//    }
//}
