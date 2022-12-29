package utilities;

import io.restassured.response.Response;
import pojos.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToText {


    public static void saveProductsData(String fileName, Product[] products) {



        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < products.length; i++) {

                writer.append(products[i].getId() + ",\n");
                writer.append(products[i].getName() + ",\n");
                writer.append(products[i].getPrice() + ",\n");
                writer.append(products[i].getBrand() + ",\n");
                writer.append(products[i].getCategory() + ",\n");
                writer.append("-----------------------------------------------" + ",\n");
            }

            writer.close();

        } catch (Exception e) {

        }
    }
}