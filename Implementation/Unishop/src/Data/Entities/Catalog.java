package Data.Entities;

import Data.Entities.Products.Product;
import Data.Entities.Users.Seller;

import java.util.HashMap;

public class Catalog {
    public static HashMap<Integer,Object[]> catalogMap=new HashMap<Integer,Object[]>();

    public static void update(HashMap<Product,Integer> products){
        for(Product product: products.keySet()){
            Object[] obj=catalogMap.get(product.getId());
            Product current= (Product) obj[0];
            //get the quantity of items in the shopping cart from products HashMap
            if(current.getquantity()>products.get(product)) product.setquantity((int) (current.getquantity()-products.get(product)));
            else catalogMap.remove(product.getId());
        }
    }
    public static Product getProduct(int id){
        return catalogMap.containsKey(id)?(Product)catalogMap.get(id)[0]:null;
    }
    public static Seller getSeller(int id){
        return catalogMap.containsKey(id)?(Seller)catalogMap.get(id)[1]:null;
    }
}