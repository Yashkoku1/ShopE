package com.halim.web.service;

import com.halim.dao.OrderRepository;
import com.halim.model.CartItem;
import com.halim.model.CartWithUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repo;
    public List<CartWithUser> getAll()
    {
        return repo.findAll();
    }

}
