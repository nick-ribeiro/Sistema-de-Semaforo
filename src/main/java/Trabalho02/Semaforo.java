package Trabalho02;

/**
 * Classe Semaforo tem a função de sincronizar o projeto.
 * @author Nícolas
 */
public class Semaforo {
    
    private String carros;
    private boolean concluido;
  
    public Semaforo(){
        this.concluido = false;
    }

/**
 * <p> Metodo construtor de receber a string carros e faz a sincronização de forma que apenas uma direção seja inicializada
 * por vez até o fechamento do semaforo para aquela direção </p>
 * @return carros
 */
    public synchronized String getCarros() {
        try {
            while (!this.concluido) {
                wait();
            }
            this.concluido = false;
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carros;
    }

/**
 * <p> Metodo de sincronização para setar a string carros </p>
 */ 
    public synchronized void setCarros(String carros) {
        try {
                while (this.concluido)
                    wait();
                this.carros = carros;
                this.concluido = true;
                notify();
        } catch (Exception e) {

            e.printStackTrace();
        }
        this.carros = carros;
    }
}
