package tacos.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TacoCloudClient {
    private RestTemplate rest;

    public TacoCloudClient(RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject("http://localhost:8080/data-api/ingredients/{id}", Ingredient.class, ingredientId);
//        Map<String, String> map = new HashMap<>();
//        map.put("id", ingredientId);
//        return rest.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, map);
    }

    public List<Ingredient> getAllIngredients() {
        return rest.exchange("http://localhost:8080/data-api/ingredients",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {
                        })
                .getBody();
    }

    public void updateIngredient(Ingredient ingredient) {
        rest.put("http://localhost:8080/data-api/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient) {
        rest.delete("http://localhost:8080/data-api/ingredients/{id}", ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return rest.postForObject("http://localhost:8080/data-api/ingredients", ingredient, Ingredient.class);
    }

}
