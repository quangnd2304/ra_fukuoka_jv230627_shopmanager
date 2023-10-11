package ra.presentation;

import ra.bussinessImp.CategoriesImp;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesPresentation {
    public static void displayMenuCategories(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        boolean isExit = true;
        do {
            System.out.println("****************CATEGORIES MENU***********");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CategoriesImp.displayCategories(listCategories);
                    break;
                case 2:
                    CategoriesImp.createCatalog(scanner,listCategories);
                    break;
                case 3:
                    boolean result = CategoriesImp.updateCatalog(scanner,listCategories);
                    if (result){
                        System.out.println("Cập nhật thành công");
                    }
                    break;
                case 4:
                    CategoriesImp.deleteCatalog(scanner,listCategories,listProducts);
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 5");
            }
        } while (isExit);
    }
}
