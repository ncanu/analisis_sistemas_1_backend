package com.example.warehouse.controllers;

import com.example.clients.models.Client;
import com.example.common.validators.auth.user.Secured;
import com.example.warehouse.beans.WarehouseBean;
import com.example.warehouse.models.Warehouse;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/warehouse")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WarehouseController {

    @EJB
    WarehouseBean warehouseBean;

    @GET
    @Secured
    public List<Warehouse> allWarehouses()
    {
        return warehouseBean.all();
    }

    @POST
    @Path("/create")
    public Warehouse createWarehouse(@Valid WarehouseRequest warehouseRequest)
    {
        Warehouse warehouse = new Warehouse();
        warehouse.setCode(warehouseRequest.getCode());
        warehouse.setName(warehouseRequest.getName());
        warehouse.setStatus(true);
        warehouseBean.persistWarehouse(warehouse);
        return warehouse;
    }

    @POST
    @Path("/edit/{id}")
    public Warehouse createWarehouse(@Valid WarehouseRequest warehouseRequest, @PathParam("id") Long id)
    {
        Warehouse warehouse = warehouseBean.byId(id);
        warehouse.setCode(warehouseRequest.getCode());
        warehouse.setName(warehouseRequest.getName());
        warehouse.setStatus(true);
        warehouseBean.mergeWarehouse(warehouse);
        return warehouse;
    }
}
