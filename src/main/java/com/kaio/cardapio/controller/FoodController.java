package com.kaio.cardapio.controller;

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

@RestController
@RequestMapping(value = "/food" )
public class FoodController {

	@Autowired
	private FoodRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
		return;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/food")
	public List<FoodResponseDTO> getAll() {
	
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;
	}
	
	
}
