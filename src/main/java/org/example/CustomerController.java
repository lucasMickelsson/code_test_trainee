package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerController {

    private List<Customer> customerList;
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerList);
        return "customers";
    }

    @Bean
    private void initializeData() {
        URL resource = Main.class.getClassLoader().getResource("prospects.txt");
        File file = new File(resource.getFile());

        List<String> list = new ArrayList<>();
        customerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] line1 = line.split(",");
                list.addAll(Arrays.asList(line1));
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        list.set(16, "Clarencé Andersson");
        list.remove("Andersson\"");

        for (int i = 4; i < 20; i += 4) {
            Customer customer = new Customer(list.get(i), Double.parseDouble(list.get(i + 1)),
                    Double.parseDouble(list.get(i + 2)), Integer.parseInt(list.get(i + 3)));
            customerList.add(customer);
        }
    }

    @Bean
    private void printMortgageCalculations() {
        for (Customer customer : customerList) {
            MortageHandler mortgageHandler = new MortageHandler(customer.getInterest(),
                    customer.getTotal_loan(),
                    customer.getYears());

            System.out.println(customer.getName() + ": " + mortgageHandler.calculate_mortage());
        }
    }
    @GetMapping("/newCustomer")
    public String newCustomer(Model model) {
        model.addAttribute("customerForm", new Customer(null, 0, 0, 0));
        return "newCustomer"; // Redirect to the customer list page
    }
    @PostMapping("/newCustomer")
    public String newCustomer(@ModelAttribute Customer customer, Model model) {
        Customer customer1 = new Customer(customer.getName(),
                customer.getTotal_loan(), customer.getInterest(), customer.getYears());
        model.addAttribute("customerForm", customer1);
        customerList.add(customer1);
        return "customers"; // Redirect to the customer list page
    }
}
