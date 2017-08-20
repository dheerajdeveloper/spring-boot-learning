package com.notification.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 17/08/17.
 */

@JsonIgnoreProperties
public class OrderJson {

    @JsonProperty("OrderId")
    String OrderId;

    @JsonProperty("CustomerId")
    String CustomerId;

    @JsonProperty("Timestamp")
    String Timestamp;

    @JsonProperty("Address")
    String Address;

    @JsonProperty("Products")
    List<ProductJson> Products;

    public String getOrderId() {
        return OrderId;
    }


    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<ProductJson> getProducts() {
        return Products;
    }

    public void setProducts(List<ProductJson> products) {
        Products = products;
    }
}


class test{
    public static void main(String[] args) throws IOException {
        OrderJson orderJson = new OrderJson();
        orderJson.setOrderId("124");
        orderJson.setAddress("Bangalore");
        orderJson.setCustomerId("6");
        orderJson.setTimestamp("");
        final ProductJson productJson1 = new ProductJson(){{
            setProductId("156");
            setTags(new ArrayList<String>(){{
                add("MENS");
                add("SHOES");
                add("FASHION");
                add("ACCESSORIES");

            }});
            setName("Reebok   Running   SHOES");
            setPrice("5606.2");
            setQty("2");
        }};
        final ProductJson productJson2 = new ProductJson(){{
            setProductId("154");
            setTags(new ArrayList<String>(){{
                add("MENS");
                add("TSHIRT");
                add("FASHION");
                add("CLOTHING");

            }});
            setName("Mens Sports Tshirt");
            setPrice("1800");
            setQty("5");
        }};

        List<ProductJson> productList = new ArrayList<ProductJson>(){{
            add(productJson1);
            add(productJson2);
        }};
        orderJson.setProducts(productList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(orderJson);

        OrderJson obj = mapper.readValue(jsonInString, OrderJson.class);

        System.out.println(obj.toString());
    }
}