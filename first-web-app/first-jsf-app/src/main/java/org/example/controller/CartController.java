package org.example.controller;

import org.example.persist.Product;
import org.example.service.CartService;
import org.example.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public void add(ProductRepr product) {
        cartService.add(product);
    }
    
    public void remove(Product product){
        cartService.remove(product.getId());
    }

    public List<ProductRepr> findAll(){
        return cartService.findAll();
    }
}
