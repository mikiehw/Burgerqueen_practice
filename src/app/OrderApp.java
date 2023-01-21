package app;

import app.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    public void start() {
        ProductRepository productRepository = new ProductRepository();
        Menu menu = new Menu(productRepository.getAllProducts());
        Cart cart = new Cart(productRepository,menu);
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if(input.equals("+")) {
                // 주문내역출력
                  break;
            } else {
                int menuNumber = Integer.valueOf(input);
                if(menuNumber == 0) cart.printCart();
                else if (menuNumber >= 1 && menuNumber <= productRepository.getAllProducts().size()){
                    cart.addToCart(menuNumber);
                }
            }

            /*
            * 메뉴 출력  vv  complete!!!
            * 사용자 입력 받기(메뉴번호(1~6),장바구니번호,주문하기번호)
            * if(사용자 입력이 + 라면 (=숫자가 아니라면) )
            *   주문내역출력
            * else(사용자 입력이 메뉴번호(숫자)라면)
            *   if(사용자 입력이 0(장바구니번호)라면)
            *     장바구니내역출력
            *   else
            *     고른 상품에 대한 각각의 옵션 고르기를 보여주고 선택을 받고 장바구니에 담기. 그리고 다시 메뉴출력
            * */
        }
    }
}
