package de.dennis_boldt;

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
    @Path("/1")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> list1() {
        List<User> users = new ArrayList<User>();
        return users;
    }

    @GET
    @Path("/2")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> list2() {
        List<User> users = new ArrayList<User>();
        users.add(new User(100, "test"));
        return users;
    }

}
