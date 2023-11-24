package com.halim.web.Controller;

import com.halim.model.Product;
import com.halim.model.User;
import com.halim.model.Vendor;
import com.halim.web.service.UserService;
import com.halim.web.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/Abc")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    VendorService vendorService;

    @GetMapping("/registration")
    public String show(Model model) {
        User u=new User();
        model.addAttribute("u",u);

        return "Admin/userRegistration";
    }
    @PostMapping("/saver")
    public String save1(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("addrs")String addrs,@RequestParam("password")String password,@RequestParam("cpassword")String cpassword,@RequestParam("limit")int limit)
    {
        userService.save(name,email,password,cpassword,addrs,limit);
        return "Admin/userRegistration";
    }

    @GetMapping("/userlogin")
    public String showForm() {
        return "Admin/userlogin";
    }

    @PostMapping("/welcome")
    public String userenter(@RequestParam("email") String email,
                            @RequestParam("password") String password , HttpServletRequest request, @ModelAttribute ("user")User user, Model model) {
        Vendor vauth=vendorService.login(email,password);
        User authuser=userService.login(email,password);
        System.out.println(authuser);
//        User users = (User) request.getSession().getAttribute("users");
        request.getSession().setAttribute("authuser",authuser);
        if(Objects.nonNull(authuser))
        {
//
            request.getSession().setAttribute("authuser",authuser);

            String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
            User ab= (User) request.getSession(true).getAttribute("authuser");
            long userid= ab.getID();

        System.out.println(userid);
      List<Product> recommnededProductList=userService.getRecoomendedProduct(userid);
            model.addAttribute("recommnededProductList",recommnededProductList);

            System.out.println(recommnededProductList);

            //   request.setAttribute("welcome", true);
            return "redirect:/";

        }
        else if(email.equals("admin@gmail.com")&& password.equals("admin@123"))
        {
            return "Admin/index";

        }
        else if(Objects.nonNull(vauth))
        {
            return "Admin/Showorder";
        }
//        if(userRepository.findByEmailAndPassword(use.getEmail(),use.getPassword()) != null) {
//            session.setAttribute("name",use.getName());
//            return "redirect:/";
//
//        }

//
        else {
            //modelMap.put("error", "Email or Password is not correct. Pleased Try Again");

            return "Admin/userlogin" ;
        }
        //request.getSession().setAttribute("users", users.getName());
       // System.out.println(authuser.getID());
        //return "redirect:/";
    }
//@PostMapping("/welcome")
//public String showuser(@ModelAttribute("user") User user ) {
//
//    User oauthUser = userService.login(user.getEmail(), user.getPassword());
//
//
//    System.out.print(oauthUser);
//    if (Objects.nonNull(oauthUser)) {
//
//        return "redirect:/";
//
//
//    } else {
//        return "redirect:/login";
//
//
//    }
//}
@GetMapping("signin")
public String signin()
{
    return "Admin/userlogin";
}

    @RequestMapping(value="logout", method=RequestMethod.GET)
    public String logoutUser(HttpSession session){

        session.removeAttribute("authuser");
        session.removeAttribute("sessiontToken");
        return "Admin/userlogin";
    }
}
