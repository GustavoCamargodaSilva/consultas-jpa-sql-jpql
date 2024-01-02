package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2609.entities.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query(nativeQuery = true,value = "SELECT categories.name, SUM(products.amount) "
            + "FROM categories "
            + "inner join products ON products.id_categories = categories.id "
            + "group by categories.name")
    List<CategorySumProjection> search1();

    @Query(value = "SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) "
            + "FROM Product obj "
            + "group by obj.category.name")
    List<CategorySumDTO> search2();
}
