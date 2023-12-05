package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    //public PersonDepartmentDTO insert(PersonDepartmentDTO dto){

        //Person entity = new Person(); //primeiro passo criar uma entidade para copiar o dto

        //entity.setName(dto.getName()); //segundo passo copiar os atributos da entidade dto para a classe criada
       // entity.setSalary(dto.getSalary()); //segundo passo

       //Department dept = new Department(); //terceiro passo criar um departamento para ser usado

        //dept.setId(dto.getDepartment().getId()); //quarto passo pegar o departamento do dto e dar um get no id dele

       // entity.setDepartment(dept); //quinto passo apontar o dept que foi pego na entidade pessoa para associar os dois

       // entity = repository.save(entity); //sexto passo chamar o repositório para salvar

       // return new PersonDepartmentDTO(entity); //cria o construtor no departmentdto para retornar
   // }

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){

        Person entity = new Person(); //primeiro passo criar uma entidade para copiar o dto

        entity.setName(dto.getName()); //segundo passo copiar os atributos da entidade dto para a classe criada
        entity.setSalary(dto.getSalary()); //segundo passo

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId()); //terceiro passo instancia um objeto buscando pelo id no banco do department

        //dept.setId(dto.getDepartment().getId()); //quarto passo pegar o departamento do dto e dar um get no id dele

        entity.setDepartment(dept); //quinto passo apontar o dept que foi pego na entidade pessoa para associar os dois

        entity = repository.save(entity); //sexto passo chamar o repositório para salvar

        return new PersonDepartmentDTO(entity); //cria o construtor no departmentdto para retornar
    }
}
