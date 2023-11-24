package com.halim.web.service;

import com.halim.dao.CartItemRepository;
import com.halim.dao.ProductRepositry;
import com.halim.dao.UserRepository;
import com.halim.model.Product;
import com.halim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    ProductRepositry productRepositry;
    @Autowired
    CartItemRepository cartItemRepository;
    public  void save(String uname,String email,String password,String cpassword,String addrs,int limit)
    {
        User u=new User();
        //u.setID(user2.getID());
        u.setName(uname);
        u.setEmail(email);
        u.setAddrs(addrs);
        u.setPassword(password);
        u.setConfirmpassword(cpassword);
        u.setTrans_limit(limit);
        userRepo.save(u);
    }

    public User login(String email,String password)
    {
        User use=userRepo.findByEmailAndPassword(email,password);
        return use;
    }
    public User getUserById(Long id) {

        return userRepo.findById(id).get();
    }
    double findSimilarityRatio (String sentence1, String sentence2) {

        HashMap<String, Integer> firstSentenceMap = new HashMap<>();
        HashMap<String, Integer> secondSentenceMap = new HashMap<>();

        String[] firstSentenceWords = sentence1.split(" ");
        String[] secondSentenceWords = sentence2.split(" ");

        for (String word : firstSentenceWords) {
            if (firstSentenceMap.containsKey(word)) {
                firstSentenceMap.put(word, firstSentenceMap.get(word) + 1);
            }
            else {
                firstSentenceMap.put(word, 1);
            }
        }

        for (String word : secondSentenceWords) {
            if (secondSentenceMap.containsKey(word)) {
                secondSentenceMap.put(word, secondSentenceMap.get(word) + 1);
            }
            else {
                secondSentenceMap.put(word, 1);
            }
        }

        double totalWords = 0;
        double totalHits = 0;

        if (firstSentenceWords.length >= secondSentenceWords.length) {
            totalWords = firstSentenceWords.length;
            for (Map.Entry<String, Integer> entry : firstSentenceMap.entrySet()) {
                String key = entry.getKey();

                if (secondSentenceMap.containsKey(key)) {
                    totalHits = totalHits + Math.min(secondSentenceMap.get(key), firstSentenceMap.get(key));
                }
            }
        }
        else {
            totalWords = secondSentenceWords.length;
            for (Map.Entry<String, Integer> entry : secondSentenceMap.entrySet()) {
                String key = entry.getKey();

                if (firstSentenceMap.containsKey(key)) {
                    totalHits = totalHits + Math.min(secondSentenceMap.get(key), firstSentenceMap.get(key));
                }
            }

        }

        return totalHits;
    }

    public List<Product> getRecoomendedProduct(long userid) {
        long productId=cartItemRepository.findByRecommendedProduct(userid);
       Optional<Product> productOptional= productRepositry.findById(productId);
        List<Product> recommnededProductList=new ArrayList<>();
       if(productOptional.isPresent())
       {
           String productDesc=productOptional.get().getDescription();
           System.out.println( "Product desc="+productDesc);

          // List<Product>  prd=productRepositry.findByIdAndDescription();

            recommnededProductList= productRepositry.matchByDesc1(productDesc);

         System.out.println( "Product list="+recommnededProductList);
       }
        else {
            System.out.println("not avilable");
       }
        return recommnededProductList;

    }

}

