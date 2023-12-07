package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto){  //Inserindo um produto referenciando as categorias
        Product entity = new Product(); //cria um produto para ser manuseado

        entity.setName(dto.getName()); //voce faz o procedimento padrao que é copiar os dados do dto para o product criado
        entity.setPrice(dto.getPrice());

        for(CategoryDTO catDto : dto.getCategories()){ //para adicionar a lista de categorias que esta cadastrado em productDTO voce percorre ela criando um novo category
            Category cat = categoryRepository.getReferenceById(catDto.getId()); //para aparecer o nome do objeto de categoria que foi cadastrado
            //Category cat = new Category(); jeito tradicional
            //cat.setId(catDto.getId()); //voce seta os valores que vao ser adicionados na lista
            entity.getCategories().add(cat); //voce pega a lista de category dentro do product e adiciona toda vez que o for criar um categoryDto
        }

        entity = repository.save(entity); //por fim voce salva a entidade com a lista ja populada.
        return new ProductDTO(entity);
    }
}
