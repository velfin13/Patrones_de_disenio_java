package me.velfinvelasquez;

public class Main {
    public static void main(String[] args) {
        ReproductorAudio reproductorMP3 = new ReproductorMP3();
        reproductorMP3.reproducir("mp3", "cancion1.mp3");

        NuevoReproductorAudio nuevoReproductor = new NuevoReproductorAudio();
        ReproductorAudio adaptador = new AdaptadorReproductor(nuevoReproductor);
        adaptador.reproducir("mp4", "video1.mp4");
    }
}