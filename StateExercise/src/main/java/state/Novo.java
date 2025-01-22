package state;

public class Novo extends PedidoState {

    public boolean avancar(PedidoContext context) {
        context.setEstado(new Processando());
		return true;
    }

    @Override
    public String getEstado() {
        return "Novo";
    }
}
