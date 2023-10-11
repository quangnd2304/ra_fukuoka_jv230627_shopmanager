package ra.bussinessImp;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesImp {
    public static void displayCategories(List<Categories> listCategories) {
        for (Categories catalog : listCategories) {
            catalog.displayData();
        }
    }

    public static void createCatalog(Scanner scanner, List<Categories> listCategories) {
        System.out.println("Nhập vào số danh mục cần thêm mới:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Categories catalog = new Categories();
            catalog.inputData(scanner, listCategories);
            listCategories.add(catalog);
        }
    }

    public static boolean updateCatalog(Scanner scanner, List<Categories> listCategories) {
        System.out.println("Nhập vào mã danh mục cần cập nhật:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        //Lấy chỉ số phần tử cần cập nhật
        int indexUpdate = getIndexCatalogOfList(catalogId, listCategories);
        if (indexUpdate >= 0) {
            //Tìm được phần tử cần cập nhật
            System.out.println("Nhập tên danh mục cần cập nhật:");
            String catalogName = scanner.nextLine();
            if (catalogName != "" && catalogName.trim().length() > 0) {
                boolean isExist = false;
                for (int i = 0; i < listCategories.size(); i++) {
                    if (i != indexUpdate && listCategories.get(i).getName().equals(catalogName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại");
                    return false;
                }
                listCategories.get(indexUpdate).setName(catalogName);
            }
            System.out.println("Nhập vào mô tả danh mục cần cập nhật:");
            String description = scanner.nextLine();
            if (description != "" && description.trim().length() > 0) {
                listCategories.get(indexUpdate).setDescription(description);
            }
            System.out.println("Nhập vào trạng thái danh mục cần cập nhật:");
            String status = scanner.nextLine();
            if (status != "" && status.trim().length() > 0) {
                listCategories.get(indexUpdate).setStatus(Boolean.parseBoolean(status));
            }
        } else {
            System.err.println("Không tồn tại mã danh mục");
            return false;
        }
        return true;
    }

    public static void deleteCatalog(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexCatalogOfList(catalogId, listCategories);
        if (indexDelete >= 0) {
            //Kiểm tra danh mục chứa sản phẩm chưa, chưa --> xóa
            boolean isContains = false;
            for (Product product : listProducts) {
                if (product.getCatalogId()==catalogId){
                    isContains = true;
                }
            }
            if (isContains){
                System.err.println("Danh mục đã chứa sản phẩm, không thể xóa");
            }else{
                //Thực hiện xóa
                listCategories.remove(indexDelete);
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static int getIndexCatalogOfList(int catalogId, List<Categories> listCategories) {
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getId() == catalogId) {
                return i;
            }
        }
        return -1;
    }
}
