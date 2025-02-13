package com.plant_care_2025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_care_2025.model.Item;
import com.plant_care_2025.repository.ItemRepository;

@Service
public class ItemService {
	 @Autowired
	    private ItemRepository itemRepository;

	    public List<Item> getAllItems() {
	        return itemRepository.findAll();
	    }

	    public Item getItemById(Long id) {
	        return itemRepository.findById(id).orElse(null);
	    }

	    public void saveItem(Item item) {
	        itemRepository.save(item);
	    }

	    public void deleteItem(Long id) {
	        itemRepository.deleteById(id);
	    }
}
