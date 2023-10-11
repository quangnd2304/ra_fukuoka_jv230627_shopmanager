package ra.entity;

import ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {
    private int id;
    private String name;
    private String description;
    private boolean status;

    public Categories() {
    }

    public Categories(int id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, List<Categories> listCategories) {
        //Tính mã danh mục
        //size(): số phần tử của danh mục
        if (listCategories.size() == 0) {
            //Danh sách danh mục chưa chứa danh mục --> mã danh mục đầu tiên là 1
            this.id = 1;
        } else {
            int max = listCategories.get(0).getId();
            for (Categories catalog : listCategories) {
                if (max < catalog.getId()) {
                    max = catalog.getId();
                }
            }
            this.id = max + 1;
        }
        boolean isExit = true;
        System.out.println("Nhập vào tên danh muc:");
        do {
            this.name = scanner.nextLine();
            boolean isExist = false;//Không trùng lặp
            for (Categories catalog : listCategories) {
                if (catalog.getName().equals(this.name)) {
                    isExist = true;//trùng lặp
                    break;
                }
            }
            if (isExist) {
                System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
            } else {
                break;
            }
        } while (isExit);
        System.out.println("Nhập vào mô tả danh mục:");
        this.description = scanner.nextLine();
        System.out.println("Nhập vào trạng thái danh mục:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã DM: %d - Tên DM: %s - Mô tả: %s - Trạng thái: %s\n",
                this.id, this.name, this.description, this.status ? "Hoạt động" : "Không hoạt động");
    }
}
