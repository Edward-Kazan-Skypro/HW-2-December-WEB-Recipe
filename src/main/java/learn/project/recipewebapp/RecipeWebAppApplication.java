package learn.project.recipewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class RecipeWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeWebAppApplication.class, args);
    }

    //@Bean
    //public Docket productApi() {
        //return new Docket(DocumentationType.SWAGGER_2).select()
        //        .apis(RequestHandlerSelectors.basePackage("learn.project.recipewebapp")).build();
    //}
}
