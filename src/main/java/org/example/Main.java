package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String ... args) throws Exception{
        URL resource = Main.class.getClassLoader().getResource("prospects.txt");
        File file= new File(resource.getFile());

        List<String> list= new ArrayList<>();
        List<Customer> customerList= new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(file))) {
            String line;
            while ((line= br.readLine()) !=null){
                String[] line1= line.split(",");
                list.addAll(Arrays.asList(line1));
            }
        }catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        list.set(16, "Clarencé Andersson");
        list.remove("Andersson\"");

        for (int i= 4; i<20; i+=4){
            Customer customer= new Customer(list.get(i), Double.parseDouble(list.get(i+1)),
                    Double.parseDouble(list.get(i+2)), Integer.parseInt(list.get(i+3)));
            customerList.add(customer);
        }

        for (Customer customer :customerList) {
            MortageHandler mortageHandler = new MortageHandler(customer.getInterest(),
                    customer.getTotal_loan(),
                    customer.getYears());

            System.out.println(customer.getName()+ ": " +mortageHandler.calculate_mortage());
        }
    }
}