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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
