package app.product;

import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductRepository {
    private ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Hamburger(1,"새우버거",3500,500,false,4500),
            new Hamburger(2,"치킨버거",4000,600,false,5000),
            new Side(3,"포테토칩",1000,300,1),
            new Side(4,"어니언링",1000,300,1),
            new Drink(5, "코카콜라", 1000,200,true),
            new Drink(6, "제로콜라", 1000,0,true)
    )
    );

    public ArrayList<Product> getAllProducts() {
        return products;
    }
    public Product findById(int productId) {
        for(Product product : products) {
            if (productId == product.getId()) return product;
        }
        return null;
    }
}
