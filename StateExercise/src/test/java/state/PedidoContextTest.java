package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoContextTest {

    private PedidoContext pedido;

    @BeforeEach
    public void setUp() {
        // Inicia o pedido no estado "Novo"
        pedido = new PedidoContext(new Novo());
    }

    // Testes para estado "Novo"

    @Test
    public void deveAvancarEstadoDeNovoParaProcessando() {
        assertTrue(pedido.avancar());
        assertEquals("Processando", pedido.getEstadoAtual());
    }

    @Test
    public void deveCancelarEstadoNovo() {
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    // Testes para estado "Processando"

    @Test
    public void deveAvancarEstadoDeProcessandoParaEnviado() {
        pedido.setEstado(new Processando());
        assertTrue(pedido.avancar());
        assertEquals("Enviado", pedido.getEstadoAtual());
    }

    @Test
    public void deveCancelarEstadoProcessando() {
        pedido.setEstado(new Processando());
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    // Testes para estado "Enviado"

    @Test
    public void deveAvancarEstadoDeEnviadoParaEntregue() {
        pedido.setEstado(new Enviado());
        assertTrue(pedido.avancar());
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    @Test
    public void naoDeveCancelarEstadoEnviado() {
        pedido.setEstado(new Enviado());
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    // Testes para estado "Entregue"

    @Test
    public void naoDeveAvancarEstadoEntregue() {
        pedido.setEstado(new Entregue());
        assertFalse(pedido.avancar());
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    @Test
    public void naoDeveCancelarEstadoEntregue() {
        pedido.setEstado(new Entregue());
        assertFalse(pedido.cancelar());
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    // Testes para estado "Cancelado"

    @Test
    public void naoDeveAvancarEstadoCancelado() {
        pedido.setEstado(new Cancelado());
        assertFalse(pedido.avancar());
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    @Test
    public void naoDeveCancelarEstadoCancelado() {
        pedido.setEstado(new Cancelado());
        assertFalse(pedido.cancelar());
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }
}
