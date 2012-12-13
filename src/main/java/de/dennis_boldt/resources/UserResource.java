package de.dennis_boldt.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Boldt
 */
@Path("/users")
public class UserResource {
    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> json() {
        List<User> users = new ArrayList<User>();
        users.add(new User(100, "test"));
        return users;
    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> xml() {
        List<User> users = new ArrayList<User>();
        users.add(new User(100, "test"));
        return users;
    }
}
