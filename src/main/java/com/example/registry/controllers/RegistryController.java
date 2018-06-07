package com.example.registry.controllers;

import com.example.common.utils.properties.PropertiesFromFile;
import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.registry.beans.RegistryBean;
import com.example.registry.models.Registry;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Path("/registries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistryController {

    @EJB
    RegistryBean registryBean;

    @Inject
    @AuthenticatedUser
    User user;

    @Inject
    @PropertiesFromFile
    Properties properties;

    @EJB
    UserBean userBean;

    @GET
    public List<RegistryResponse> allUsers()
    {
        List<Registry> registries = registryBean.all();
        List<RegistryResponse> response = new ArrayList<>();
        for(Registry x: registries)
        {
            RegistryResponse registryResponse = new RegistryResponse();
            registryResponse.setRegistry(x);
            registryResponse.setUserName(userBean.byId(x.getUserId()).getName() +" " +userBean.byId(x.getUserId()).getLastName());
            response.add(registryResponse);
        }

        return response;
    }

}
