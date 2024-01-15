package factoryMethod;

public class PagoPacifico implements Pago{
    @Override
    public void crearPago() {
        System.out.println("Pago con Pacifico");
    }
}
