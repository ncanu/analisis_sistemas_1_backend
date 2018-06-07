package com.example.product.controllers;

import com.example.common.utils.properties.PropertiesFromFile;
import com.example.common.validators.auth.user.Secured;
import com.example.product.beans.InventoryBean;
import com.example.product.models.Inventory;
import com.example.product.models.Product;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryController {

    @Inject
    @PropertiesFromFile
    Properties properties;

    @EJB
    UserBean userBean;

    @EJB
    InventoryBean inventoryBean;

    @GET
    @Path("/products")
    public List<Product> allProducts()
    {
        return inventoryBean.allProducts();
    }



    @GET
    @Path("/warehouse/{id}")
    public List<InventoryResponse> inventoryByWarehouse(@PathParam("id") long id)
    {
        List<Inventory> inventories = inventoryBean.InventoryByWarehouse(id);
        List<InventoryResponse> response = new ArrayList<>();

        for(Inventory x: inventories)
        {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setInventory(x);
            inventoryResponse.setProduct(inventoryBean.productById(x.getProductId()));
            response.add(inventoryResponse);
        }
        return response;
    }

    @POST
    @Path("/inventory")
    public Inventory addInventory(@Valid InventoryRequest request)
    {
        Inventory inventory = new Inventory();
        inventory.setCost(request.getCost());
        inventory.setPrice(request.getPrice());
        inventory.setProductId(request.getProduct());
        inventory.setWarehouseId(request.getWarehouse());
        inventory.setQuantity(request.getQuantity());
        inventoryBean.persistInventory(inventory);
        return inventory;
    }
}
