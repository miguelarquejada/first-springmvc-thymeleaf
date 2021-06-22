package com.marb.productscrudwebtemplate.controllers;

import com.marb.productscrudwebtemplate.models.Product;
import com.marb.productscrudwebtemplate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/produtos";
    }

    @GetMapping("/produtos")
    public String allProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/editar/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.getById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping ("/editar")
    public String updateProduct(@ModelAttribute Product newProduct, Model model) {
        Product product = productRepository.getById(newProduct.getId());
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productRepository.save(product);

        return "redirect:/produtos";
    }

    @GetMapping("/novo")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping("/novo")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productRepository.save(product);
        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
