package com.j49u4r.rest

import io.swagger.models.Swagger
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.wildfly.swarm.container.Container
import org.wildfly.swarm.jaxrs.JAXRSArchive
import org.wildfly.swarm.swagger.SwaggerArchive

import java.util.logging.Logger

/**
 * Created by j49u4r on 9/23/16.
 */
class AppStart {

    private static Logger logger;

    public static void main(String[] args) {

        final Container container = new Container();

        System.setProperty("remote.maven.repo", "https://repository.jboss.org/nexus/content/groups/m2-proxy/,https://repository.jboss.org/nexus/content/groups/public/")
        System.setProperty("maven.download.message", "true")


        final JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addResource(JaxRsEntryPoint.class)
        deployment.addResource(CompanyCtrl.class)
        deployment.addResource(CorsFilter.class)
        deployment.addAllDependencies()

        final SwaggerArchive archive = deployment.as(SwaggerArchive.class)
        archive.setResourcePackages("com.j49u4r.rest")
        archive.setTitle("Swagger Demo")

        container.start()

        logger  = Logger.getLogger(AppStart.class.getName())
        logger.info(deployment.toString(true))

        container.deploy()

    }
}
