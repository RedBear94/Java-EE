package org.example.service;

import org.example.service.repr.ProductRepr;

import java.util.List;

public interface ProductServiceRemote {

    List<ProductRepr> findAllRemote();
}