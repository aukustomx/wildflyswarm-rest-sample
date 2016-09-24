package com.j49u4r.rest

import io.swagger.annotations.Api

import javax.ws.rs.GET
import javax.ws.rs.Path

/**
 * REST interface
 * Created by j49u4r on 9/23/16.
 */
@Path("/company")
@Api(value = "/", description = "Sample Rest API using Wildfly Swarm")
class CompanyCtrl {

    @GET
    @Path("/welcome")
    String helloWorld() {
        return "Bienvenido a la prueba de Rest API usando Wildfly Swarm";
    }
}
