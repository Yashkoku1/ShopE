package com.halim.web.service;

import com.halim.dao.VendorRepository;
import com.halim.model.User;
import com.halim.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    @Autowired
    VendorRepository repo;
    public void saveTo(String name, String email, long mobile, String psw, String pswr) {
        Vendor v=new Vendor();
        v.setName(name);
        v.setEmail(email);
        v.setMobile_no(mobile);
        v.setPassword(psw);
        v.setConfirmpassword(pswr);
        repo.save(v);
    }

    public Vendor login(String email, String password) {
        Vendor use=repo.findByEmailAndPassword(email,password);
        return use;
    }
}
