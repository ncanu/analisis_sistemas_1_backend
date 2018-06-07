package com.example.clients.controllers;

import com.example.clients.beans.ClientBean;
import com.example.clients.models.Client;
import com.example.common.utils.properties.PropertiesFromFile;
import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Properties;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    @PropertiesFromFile
    Properties properties;

    @EJB
    UserBean userBean;

    @Inject
    @AuthenticatedUser
    User user;

    @EJB
    ClientBean clientBean;

    @GET
    @Secured
    public List<Client> allUsers()
    {
        return clientBean.all();
    }

    @POST
    @Path("/client")
    public Client createClient(@Valid ClientRequest request)
    {
        Client client = new Client();
        client.setAddress(request.getAddress());
        client.setEmail(request.getEmail());
        client.setLastName(request.getLastName());
        client.setName(request.getName());
        client.setNit(request.getNit());
        client.setPhone(request.getPhone());
        client.setStatus(true);
        clientBean.persistClient(client);
        return client;
    }

    @POST
    @Path("/client/edit")
    public Client editClient(@Valid ClientRequest request)
    {
        Client client = new Client();
        client.setAddress(request.getAddress());
        client.setEmail(request.getEmail());
        client.setLastName(request.getLastName());
        client.setName(request.getName());
        client.setNit(request.getNit());
        client.setPhone(request.getPhone());
        client.setStatus(true);
        clientBean.mergeClient(client);
        return client;
    }

}
