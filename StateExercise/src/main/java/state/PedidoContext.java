package state;

public class PedidoContext {
    private PedidoState estadoAtual;

    public PedidoContext(PedidoState estadoInicial) {
        this.estadoAtual = estadoInicial;
    }

    public void setEstado(PedidoState estado) {
        this.estadoAtual = estado;
    }

    public boolean avancar() {
        return estadoAtual.avancar(this);
    }

    public boolean cancelar() {
        return estadoAtual.cancelar(this);
    }

    public String getEstadoAtual() {
        return estadoAtual.getEstado();
    }
}
