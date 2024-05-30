package br.edu.uniara.lpi2.rest.controller;


import br.edu.uniara.lpi2.rest.model.Employee;
import br.edu.uniara.lpi2.rest.model.EmployeePagingRepository;
import br.edu.uniara.lpi2.rest.model.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.verify;



@SpringBootTest
class EmployeeControllerTest {

    @Mock
    EmployeeRepository repository;

    @Mock
    EmployeePagingRepository pagingRepository;

    @Autowired
    @InjectMocks
    private EmployeeController controller;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("teste de inserção")
    void testeInsercao() {
        Employee employee = new Employee("teste","teste");
        var employeeSalvo = repository.save(employee);
        verify(repository).save(employee);
    }


    @Test
    void delete() {
    }
}

