package com.halim.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String password;
    private String confirmpassword;
    private  String email;
     private String addrs;

     private  int trans_limit;

    public int getTrans_limit() {
        return trans_limit;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                ", email='" + email + '\'' +
                ", addrs='" + addrs + '\'' +
                ", trans_limit=" + trans_limit +
                '}';
    }

    public void setTrans_limit(int trans_limit) {
        this.trans_limit = trans_limit;
    }

    //    @OneToOne
//    @JoinColumn(name = "cart_id")
//    @MapsId
//    private CartItem cartItem;
//@OneToOne(mappedBy = "user1", cascade = CascadeType.ALL)
//private CartItem userDetails;
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }
}
