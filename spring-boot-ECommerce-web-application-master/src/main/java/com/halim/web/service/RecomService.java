//package com.halim.web.service;
//
//import com.halim.dao.CartItemRepository;
//import com.halim.dao.ProductRepositry;
//import com.halim.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class RecomService {
//    @Autowired
//    CartItemRepository cart;
//    @Autowired
//    ProductRepositry repo;
//    public void  getRecommenProduct() {
//
//
//        String id;
//        String str = cart.findByProductId(id);
//        String desc = repo.findDescription(str);
//
//    }
//    double findSimilarityRatio (String sentence1, String sentence2) {
//
//        HashMap<String, Integer> firstSentenceMap = new HashMap<>();
//        HashMap<String, Integer> secondSentenceMap = new HashMap<>();
//
//        String[] firstSentenceWords = sentence1.split(" ");
//        String[] secondSentenceWords = sentence2.split(" ");
//
//        for (String word : firstSentenceWords) {
//            if (firstSentenceMap.containsKey(word)) {
//                firstSentenceMap.put(word, firstSentenceMap.get(word) + 1);
//            }
//            else {
//                firstSentenceMap.put(word, 1);
//            }
//        }
//
//        for (String word : secondSentenceWords) {
//            if (secondSentenceMap.containsKey(word)) {
//                secondSentenceMap.put(word, secondSentenceMap.get(word) + 1);
//            }
//            else {
//                secondSentenceMap.put(word, 1);
//            }
//        }
//
//        double totalWords = 0;
//        double totalHits = 0;
//
//        if (firstSentenceWords.length >= secondSentenceWords.length) {
//            totalWords = firstSentenceWords.length;
//            for (Map.Entry<String, Integer> entry : firstSentenceMap.entrySet()) {
//                String key = entry.getKey();
//
//                if (secondSentenceMap.containsKey(key)) {
//                    totalHits = totalHits + Math.min(secondSentenceMap.get(key), firstSentenceMap.get(key));
//                }
//            }
//        }
//        else {
//            totalWords = secondSentenceWords.length;
//            for (Map.Entry<String, Integer> entry : secondSentenceMap.entrySet()) {
//                String key = entry.getKey();
//
//                if (firstSentenceMap.containsKey(key)) {
//                    totalHits = totalHits + Math.min(secondSentenceMap.get(key), firstSentenceMap.get(key));
//                }
//            }
//
//        }
//
//        return totalHits;
//    }
//
//}
