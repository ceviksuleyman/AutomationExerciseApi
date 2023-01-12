package utilities;

import pojos.Product;
import pojos.reqresPojo.Reqres;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToText {


    public static void saveProductsData(String fileName, Product[] product) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < product.length; i++) {

                writer.append(product[i].getId() + ",\n");
                writer.append(product[i].getName() + ",\n");
                writer.append(product[i].getPrice() + ",\n");
                writer.append(product[i].getBrand() + ",\n");
                writer.append(product[i].getCategory() + ",\n");
                writer.append("-----------------------------------------------" + ",\n");
            }

            writer.close();

        } catch (Exception e) {

        }
    }
}