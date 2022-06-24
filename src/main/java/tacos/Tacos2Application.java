package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.data.IngredientRepository;
import tacos.Ingredient.Type;


@SpringBootApplication
public class Tacos2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tacos2Application.class, args);
    }


}
