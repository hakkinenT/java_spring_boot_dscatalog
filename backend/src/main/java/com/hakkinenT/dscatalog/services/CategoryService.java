package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.CategoryDTO;
import com.hakkinenT.dscatalog.entities.Category;
import com.hakkinenT.dscatalog.repositories.CategoryRepository;
import com.hakkinenT.dscatalog.services.exceptions.DatabaseException;
import com.hakkinenT.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable){
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(cat -> new CategoryDTO(cat));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto){
        Category category = new Category();
        category.setName(dto.getName());

        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id,CategoryDTO dto){
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setName(dto.getName());

            category = categoryRepository.save(category);
            return new CategoryDTO(category);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!categoryRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

        try {
            categoryRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de Integridade");
        }
    }
}
