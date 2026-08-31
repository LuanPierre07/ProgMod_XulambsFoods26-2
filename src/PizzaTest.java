import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {

    Pizza pizza;

    @BeforeEach
    public void setUp(){
        //Arrange
        pizza = new Pizza();
        pizza.adicionarIngredientes(2);
    }

    @Test
    public void adicionaIngredientesCorretamente(){

        //Act
        int quantos = pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(6, quantos);
    }

    @Test
    public void naoAdicionaIngredienteNegativo(){

        //Act
        int quantos =
            pizza.adicionarIngredientes(-7);

        //Assert:
        assertEquals(2, quantos);
    }

    @Test public void naoUltrapassaMaximoDeIngredientes(){

        //Act
        int quantos = pizza.adicionarIngredientes(7);

        //Assert
        assertEquals(2, quantos);

    }

    @Test
    public void calcularOPrecoCorretamente(){

        //Act
        double preco = pizza.valorFinal();

        //Assert
        assertEquals(39, preco, 0.01);
    }
    
}
