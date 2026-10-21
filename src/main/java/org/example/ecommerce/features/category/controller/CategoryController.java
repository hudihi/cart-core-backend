package org.example.ecommerce.features.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.category.dto.CategoryRequest;
import org.example.ecommerce.features.category.dto.CategoryResponse;
import org.example.ecommerce.features.category.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        CategoryResponse response = categoryService.createCategory(request);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id){
        return ResponseEntity.status(OK).body(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> listCategories(
            @PageableDefault(size = 20, sort = "name")Pageable pageable
            ){
        return ResponseEntity.status(OK).body(categoryService.listCategories(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable Long id, @Valid @RequestBody CategoryRequest request){
        return ResponseEntity.status(OK).body(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
