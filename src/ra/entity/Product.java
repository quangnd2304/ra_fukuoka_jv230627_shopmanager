package ra.entity;

import ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String id;
    private String name;
    private int catalogId;
    private float importPrice;
    private float exportPrice;
    private boolean status;

    public Product() {
    }

    public Product(String id, String name, int catalogId, float importPrice, float exportPrice, boolean status) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        boolean isExit = true;
        System.out.println("Nhập vào mã sản phẩm:");
        do {
            this.id = scanner.nextLine();
            if (this.id.length() == 4) {
                if (this.id.startsWith("P")) {
                    boolean isExist = false;
                    for (Product product : listProducts) {
                        if (product.getId().equals(this.id)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                    } else {
                        break;
                    }
                } else {
                    System.err.println("Mã danh mục phải bắt đầu là ký tự P, vui lòng nhập lại");
                }
            } else {
                System.err.println("Mã danh mục phải gồm 4 ký tự, vui lòng nhập lại");
            }
        } while (isExit);
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            this.name = scanner.nextLine();
            boolean isExist = false;
            for (Product product : listProducts) {
                if (product.getName().equals(this.name)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
            } else {
                break;
            }
        } while (isExit);
        System.out.println("Lựa chọn danh mục của sản phẩm:");
        do {
            for (int i = 0; i < listCategories.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), listCategories.get(i).getName());
            }
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > listCategories.size()) {
                System.err.println("Không tồn tại danh mục, vui lòng chọn lại");
            } else {
                this.catalogId = listCategories.get(choice - 1).getId();
                break;
            }
        } while (isExit);
        System.out.println("Nhập vào giá nhập:");
        do {
            this.importPrice = Float.parseFloat(scanner.nextLine());
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (isExit);
        System.out.println("Nhập vào trạng thái sản phẩm:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã SP: %s - Tên SP: %s - Mã danh mục: %d\n", this.id, this.name, this.catalogId);
        System.out.printf("Giá nhập: %f - Giá bán: %f - Trạng thái: %s\n",
                this.importPrice, this.exportPrice, this.status ? "Hoạt động" : "Không hoạt động");
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice * RATE;
    }
}
