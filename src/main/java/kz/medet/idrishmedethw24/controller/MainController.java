package kz.medet.idrishmedethw24.controller;

import kz.medet.idrishmedethw24.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getMainPage(Model model){
        model.addAttribute("products", productService.getProductList());
        return "main";
    }

    @GetMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/main";
    }
}
