package state;

public class Enviado extends PedidoState {

    @Override
    public boolean avancar(PedidoContext context) {
        context.setEstado(new Entregue());
        return true;
    }

    @Override
    public String getEstado() {
        return "Enviado";
    }
}

