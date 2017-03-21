package com.qph.myfirstthymeleaf.web.controller;

import com.qph.myfirstthymeleaf.business.entities.Product;
import com.qph.myfirstthymeleaf.business.services.ProductService;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by quoc on 10/01/2017.
 */
public class ProductListController implements IGTVGController {

    private ProductService productService;

    public ProductListController(){
        productService = new ProductService();
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, ITemplateEngine templateEngine) throws IOException {
        WebContext webContext = new WebContext(request, response, servletContext, request.getLocale());
        List<Product> productList = productService.findAll();
        webContext.setVariable("prods", productList);
        templateEngine.process(GTVGConstants.PAGE_LIST, webContext, response.getWriter());
    }
}
