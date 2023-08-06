package com.kaio.cardapio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.cardapio.food.Food;
import com.kaio.cardapio.food.FoodRepository;
import com.kaio.cardapio.food.FoodRequestDTO;
import com.kaio.cardapio.food.FoodResponseDTO;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/food")
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodRepository repository;
    
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
    }
    @Autowired
    private FoodRepository foodRepository;

    @PostConstruct
    public void initialize() {
        List<FoodRequestDTO> foodDataList = new ArrayList<>();
        foodDataList.add(new FoodRequestDTO("Macarrão ao molho", "https://receitasgalo.com.br/images/receitas/71/galo-imagem-receitas-macarrao-com-carne-de-sol-thumb-square.webp", 33.99));
        foodDataList.add(new FoodRequestDTO("Pizza Calabresa BIG", "https://blog.ceraflame.com.br/wp-content/uploads/2021/06/Pizza-Napolitana-CERAFLAME.jpg", 69.99));
        foodDataList.add(new FoodRequestDTO("Calzone Grande", "https://anamariabraga.globo.com/wp-content/uploads/2016/06/calzone.jpg", 49.99));
        foodDataList.add(new FoodRequestDTO("Strogonoff de Frango", "https://www.sabornamesa.com.br/media/k2/items/cache/08ae461f14a3d195f7e52b850155dc3c_XL.jpg", 49.99));
        foodDataList.add(new FoodRequestDTO("Alcatra com Fritas", "https://img.freepik.com/fotos-premium/bife-de-alcatra-com-batatas-fritas_538646-9513.jpg?w=2000", 25.99));
        foodDataList.add(new FoodRequestDTO("Cachorro Quente", "https://img.freepik.com/fotos-gratis/cachorro-quente-de-carne-grelhada-com-lanche-de-ketchup-ia-generativa_188544-7829.jpg?w=2000", 18.99));
        
        for (FoodRequestDTO foodData : foodDataList) {
            Food foodEntity = new Food(foodData); // Convert FoodRequestDTO to Food entity
            foodRepository.save(foodEntity); // Save the Food entity
        }
    }

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
/*@RestController
@RequestMapping(value = "/food" )
@CrossOrigin
public class FoodController {

	@Autowired
	private FoodRepository repository;
	
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
		return;
	}
	
	@GetMapping(value = "/food")
	public List<FoodResponseDTO> getAll() {
	
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;
	}
	
	
}*/
