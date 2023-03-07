import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Hilos {
    public static void main(String[] args) {
        HiloAudio hiloAudio = new HiloAudio();
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        Hilo3 hilo3 = new Hilo3();
        
        hiloAudio.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

class HiloAudio extends Thread {
    public void run() {
        try {
            File archivo = new File("audio.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
}

class Hilo1 extends Thread {
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Hilo 1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 1 interrumpido");
            }
        }
    }
}

class Hilo2 extends Thread {
    public void run() {
        for (char i = 'a'; i <='z'; i++) {
            System.out.println("Hilo 2: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 2 interrumpido");
            }
        }
    }
}

class Hilo3 extends Thread {
    public void run() {
        for (int i = 50; i > 0; i--) {
            System.out.println("Hilo 3: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 3 interrumpido");
            }
        }
    }
}
