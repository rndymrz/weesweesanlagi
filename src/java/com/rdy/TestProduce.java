/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import com.rdy.model.Customer;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author user
 */
public class TestProduce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();        
        String uri = new String("http://localhost:8084/ProduceRestfulWS/api/customers/save");
        Customer c = new Customer();
        c.setName("Rdy");
        c.setAddressline1("Pedurenan");
        c.setAddressline2("Setiabudi");
        c.setCity("Jaksel");
        
        Customer returns = rt.postForObject(uri, c, Customer.class);
    }
    
}
