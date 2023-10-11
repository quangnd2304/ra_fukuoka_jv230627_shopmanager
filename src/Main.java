import ra.entity.Categories;
import ra.entity.Product;
import ra.presentation.CategoriesPresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Categories> listCategories = new ArrayList<>();
    public static List<Product> listProducts = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*****************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    CategoriesPresentation.displayMenuCategories(scanner,listCategories,listProducts);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        }while (true);
    }
}