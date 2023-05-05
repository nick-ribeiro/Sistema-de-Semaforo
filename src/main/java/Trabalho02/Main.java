package Trabalho02;

/**
 * Classe main tem a função de inicializar o projeto.
 * @author Nícolas
 */
public class Main {

/**
 * <p> Inicializacao do main </p>
 * @param args 
 */    
    public static void main(String[] args) {

/**
 * <p> Criação da variavel carros na classe Semaforo, a qual será passada para todas as outras Threads </p>
 */          
        Semaforo carros = new Semaforo();

/**
 *  <p> São criadas as Threads para a inicialização do projeto. </p>   
 *  @since 1.0
 */           
        Norte_Sul via1 = new Norte_Sul(carros);
        via1.start();
       
        Leste_Oeste via2 = new Leste_Oeste(carros);
        via2.start();

/**
 *  <p> Try/Catch em que ambas threads aguardam a finalização das tarefas e logo em seguida são incializadas
 *  outras Threads contendo a mesma tarefa </p>
 */        
         try {
            via1.join();
            via2.join();
            
            Norte_Sul via3 = new Norte_Sul(carros);
            via3.start();
       
            Leste_Oeste via4 = new Leste_Oeste(carros);
            via4.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
