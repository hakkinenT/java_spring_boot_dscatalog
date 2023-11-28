package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.CategoryDTO;
import com.hakkinenT.dscatalog.dto.ProductDTO;
import com.hakkinenT.dscatalog.entities.Category;
import com.hakkinenT.dscatalog.entities.Product;
import com.hakkinenT.dscatalog.repositories.CategoryRepository;
import com.hakkinenT.dscatalog.repositories.ProductRepository;
import com.hakkinenT.dscatalog.services.exceptions.DatabaseException;
import com.hakkinenT.dscatalog.services.exceptions.ResourceNotFoundException;
import com.hakkinenT.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private long existingId;
    private long nonExistingId;

    private long dependentId;

    private PageImpl<Product> page;

    private Product product;

    private ProductDTO productDTO;

    private Category category;

    private long categoryId;


    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        nonExistingId = 2L;
        dependentId = 3L;
        product = Factory.createProduct();
        page = new PageImpl<>(List.of(product));
        productDTO = Factory.createProductDTOToInsert();

        category = new Category(2L, "Electronics");
        categoryId = 2L;


        when(productRepository.existsById(existingId)).thenReturn(true);
        when(productRepository.existsById(nonExistingId)).thenReturn(false);
        when(productRepository.existsById(dependentId)).thenReturn(true);

        doNothing().when(productRepository).deleteById(existingId);
        doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);


        when(productRepository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);

        when(productRepository.save(ArgumentMatchers.any())).thenReturn(product);

        when(productRepository.findById(existingId)).thenReturn(Optional.of(product));
        when(productRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        when(categoryRepository.getReferenceById(categoryId)).thenReturn(category);
    }

    @Test
    public void findAllPagedShouldReturnPage(){
        Pageable pageable = PageRequest.of(0,10);
        Page<ProductDTO> result = service.findAll(pageable);

        Assertions.assertNotNull(result);
        verify(productRepository, times(1)).findAll(pageable);
    }

    @Test
    public void insertShouldReturnProductDTO(){
        ProductDTO result = service.insert(productDTO);
        Assertions.assertNotNull(result);

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists(){
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });

        verify(productRepository, times(1)).deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenDependentId(){
        Assertions.assertThrows(DatabaseException.class, () -> {
            service.delete(dependentId);
        });
    }
}
