package pl.edu.agh.soa;

import io.swagger.jaxrs.config.BeanConfig;
import pl.edu.agh.soa.api.StudentController;
import pl.edu.agh.soa.auth.AuthenticationController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/students")
public class StudentApp extends Application {

    public StudentApp() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api/students");
        beanConfig.setResourcePackage("pl.edu.agh.soa");
        beanConfig.setTitle("Student Controller REST API Documentation");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(StudentController.class);
        resources.add(AuthenticationController.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
