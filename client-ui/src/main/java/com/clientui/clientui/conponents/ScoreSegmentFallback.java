package com.clientui.clientui.conponents;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxies.MicroserviceProduitsProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreSegmentFallback implements MicroserviceProduitsProxy {

    @Override
    public List<ProductBean> listeDesProduits() {
        return null;
    }

    @Override
    public ProductBean recupererUnProduit(int id) {
        return null;
    }
}