package com.clientui.clientui.proxies;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.configuration.LoadBalancerConfiguration;
import com.clientui.clientui.conponents.ScoreSegmentFallback;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-produits")
@LoadBalancerClient(name = "microservice-produits",configuration= LoadBalancerConfiguration.class)
//@FeignClient(name = "microservice-produits", url = "localhost:9001")
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);
}
