package com.qph.myfirstthymeleaf.business.services;

import java.util.List;

/**
 * Created by quoc on 08/01/2017.
 */
public interface SearchService<T> {
    List<T> findAll();
    T findById(Integer id);
}
