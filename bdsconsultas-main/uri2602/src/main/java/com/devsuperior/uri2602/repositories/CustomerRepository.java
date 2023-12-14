package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer,Long>{

    @Query(nativeQuery = true,value = "SELECT name " + //selecione o nome
            "FROM customers " + //na tabela customers
            "WHERE UPPER(state) = UPPER(:state)")// que o state for igual ao string state passado // true para consulta sql raiz
    List<CustomerMinProjection> serch1(String state);

    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name)" + //selecione o nome
            "FROM Customer obj " + //na jpql o nome precisa ser igual da classe e depois voce da um apelido por ex obj
            "WHERE UPPER(obj.state) = UPPER(:state)")// que o state for igual ao string state passado // true para consulta jpql
    List<CustomerMinDTO> serch2(String state);
}
