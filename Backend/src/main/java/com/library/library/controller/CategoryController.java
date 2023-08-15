package com.library.library.controller;

import com.library.library.model.Category;
import com.library.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAll();
	}

	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.addNew(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
//		Category existingCategory = categoryService.getCategoryById(id);
//		if (existingCategory == null) {
//			return ResponseEntity.notFound().build();
//		}
//		Category updatedCategory = categoryService.save(category);
//		return ResponseEntity.ok(updatedCategory);
//	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<Long> deleteCategory(@PathVariable Long id) {
//		Category existingCategory = categoryService.getCategoryById(id);
//		if (existingCategory == null) {
//			return ResponseEntity.notFound().build();
//		}
//		categoryService.delete(id);
//		return new ResponseEntity<>(id, HttpStatus.OK);
//	}
}

