package utilities;

import io.restassured.response.Response;
import pojos.Product;
import pojos.Reqres;

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

    public static void saveUserData(String fileName, Reqres[] reqres) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < reqres.length; i++) {

                writer.append(reqres[i].getData().getId() + "[" + i + "]" + ",\n");
                writer.append(reqres[i].getData().getEmail() + "[" + i + "]" + ",\n");
                writer.append(reqres[i].getData().getFirst_name() + "[" + i + "]" + ",\n");
                writer.append(reqres[i].getData().getLast_name() + "[" + i + "]" + ",\n");
                writer.append(reqres[i].getData().getAvatar() + "[" + i + "]" + ",\n");
                writer.append("-----------------------------------------------" + ",\n");
            }

            writer.close();

        } catch (Exception e) {

        }
    }
}