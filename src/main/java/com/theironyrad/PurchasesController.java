package com.theironyrad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;

/**
 * Created by BennettIronYard on 11/11/15.
 */
@Controller
public class PurchasesController {
    @Autowired
    PurchaseRepository purchases;

    @Autowired
    CustomerRepository customers;

    @PostConstruct
    public void init() {

        String fileContent = readFile("purchases.csv");
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            if (line == lines[0])
                continue;
            Purchase purchase = new Purchase();
            String[] columns = line.split(",");
            purchase.id = columns[1];
            purchase.date = columns[2];
            purchase.credit_card = columns[3];
            purchase.cvv = columns[4];
            purchase.category = columns[5];
            purchases.save(purchase);
        }
        String fileContent = readFile("customers.csv");
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            if (line == lines[0])
                continue;
            Customer customer = new Customer();
            String[] columns = line.split(",");
            customer.name = columns[1];
            customer.email = columns[2];
            customers.save(customer);
        }

    }

        @RequestMapping("/")
    public String home(){
            return "home";
    }


    static String readFile(String "purchases.csv") {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }
}
