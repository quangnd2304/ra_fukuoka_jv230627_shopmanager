package ra.bussinessImp;

import ra.entity.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductImp {
    public static void sortProductByExportPriceASC(List<Product> listProduct) {
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getExportPrice()-o2.getExportPrice()>0)?1:(o1.getExportPrice()<o2.getExportPrice())?-1:0;
            }
        });
    }
}
