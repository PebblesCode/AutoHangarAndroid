package com.wordpress.priyankvex.autohangarandroid.seed;

import com.wordpress.priyankvex.autohangarandroid.models.ServiceProvider;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 17/2/16.
 * Seed class to generate all dummy SP data.
 */
public class ServiceProviderSeed {

    public static ArrayList<ServiceProvider> getServiceProviders(){
        ArrayList<ServiceProvider> serviceProviders = new ArrayList<>();

        ServiceProvider sp = new ServiceProvider();
        sp.setName("Lorem ipsum dolor sit amet");
        sp.setAddress("Lorem ipsum dolor sit amet, pertinax periculis adipiscing sea te.");
        sp.setCity("Lorem Ipsum");
        sp.setRating(4.5f);

        serviceProviders.add(sp);
        serviceProviders.add(sp);
        serviceProviders.add(sp);
        serviceProviders.add(sp);
        serviceProviders.add(sp);
        serviceProviders.add(sp);
        serviceProviders.add(sp);

        return serviceProviders;
    }
}
