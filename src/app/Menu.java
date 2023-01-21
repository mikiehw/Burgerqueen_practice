package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> products;
    // 메뉴출력은 사용자의 입력에 따라 바뀌는 데이터가 아닌 항상 동일한 정보이다. 꼭 생성자를 통해서 주입 받아야 했을 까..?
    // 아, 만약에 메뉴 목록(레파짓토리)가 수정된다면 메뉴와 메뉴목록을 분리해서 생성자로 주입받는게 좋을듯... 메뉴수정하면 메뉴클래스도 수정해야할테니까..
    public Menu(ArrayList<Product> products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    void printDrinks(boolean printPrice) {
        System.out.println("🥤 음료");
        for(Product product : products) {
            if(product instanceof Drink) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    void printSides(boolean printPrice) {
        System.out.println("🍟 사이드");
        for(Product product : products) {
            if(product instanceof Side) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    void printHamburgers(boolean printPrice) {
        System.out.println("🍔 햄버거");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product, boolean printPrice) {
        if(printPrice) {
            System.out.printf(
                    "   (%d) %s %5dKcal %5d원\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice()
            );
        }
        else {
            System.out.printf(
                    "   (%d) %s %5dKcal\n",
                    product.getId(), product.getName(), product.getKcal()
            );
        }
    }

}
