package factoryMethod;

public class PagoPichincha implements Pago{
    @Override
    public void crearPago() {
        System.out.println("Pagando con el Pichincha");
    }
}
