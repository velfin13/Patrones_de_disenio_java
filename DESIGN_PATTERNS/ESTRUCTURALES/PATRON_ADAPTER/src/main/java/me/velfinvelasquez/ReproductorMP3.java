package me.velfinvelasquez;

// Implementación concreta de la interfaz
public class ReproductorMP3 implements ReproductorAudio {
    @Override
    public void reproducir(String tipoArchivo, String nombreArchivo) {
        if ("mp3".equalsIgnoreCase(tipoArchivo)) {
            System.out.println("Reproduciendo archivo MP3: " + nombreArchivo);
        } else {
            System.out.println("Formato no soportado");
        }
    }
}
