package me.velfinvelasquez;

// Clase adaptadora que convierte NuevoReproductorAudio a ReproductorAudio
public class AdaptadorReproductor implements ReproductorAudio {
    private NuevoReproductorAudio nuevoReproductor;

    public AdaptadorReproductor(NuevoReproductorAudio nuevoReproductor) {
        this.nuevoReproductor = nuevoReproductor;
    }

    @Override
    public void reproducir(String tipoArchivo, String nombreArchivo) {
        if ("mp4".equalsIgnoreCase(tipoArchivo)) {
            nuevoReproductor.reproducirMP4(nombreArchivo); // Usa el método específico de NuevoReproductorAudio
        } else {
            System.out.println("Formato no soportado");
        }
    }
}
