import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;
    Pizza pizzavazia;

    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
        pizzavazia = new Pizza();
        pedido.adicionarPizza(pizzavazia); 
    }

    @Test
    public void adicionaVariasPizzasCorretamente(){
        //Arrange

        //Act
            int quantidade = pedido.adicionarPizza(new Pizza());

        //Assert
        assertEquals(2,quantidade);
    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void calculaValorDoPedidoCorretamente(){
        //Arrange

        //Act
        double preco = pedido.precoAPagar();
    
        //Assert
        assertEquals(29d, preco, 0.01);
    }

    @Test 
    public void calculaPrecoPedidoVariasPizzas(){
        //Arrange
        Pizza pizza2ingrediente = new Pizza(2);
        pedido.adicionarPizza(pizza2ingrediente);

        //Act
        double preco = pedido.precoAPagar();

        //Assert
        assertEquals(68d, preco, 0.01);
    }

    @Test 
    public void geraRelatorioPedido(){
        //Act
        String cupom = pedido.relatorio();

        //Assert
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizzas") &&
            cupom.contains("aberto")
        );
    }
}