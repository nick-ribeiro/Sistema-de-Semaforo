package Trabalho02;

/**
 * Thread que contem a direção Norte-Sul do cruzamento, em que os carros aguardam o sinal abrir
 * @author Nicolas
 */
public class Norte_Sul extends Thread{
    
    private Semaforo carros;
    
/**
* <p> Criação de uma string carro, a qual irá setar o metodo getCarros() da classe Semaforo </p>
**/
    String carro = "Semaforo aberto para via Norte-Sul";

/**
* <p> Criação de um contador, o qual funciona como a quantidade de carros esperando na direção Leste-Oeste </p>
**/
    int cont = 0;
    
    public Norte_Sul (Semaforo carros) {
        this.carros = carros;
    }

/**
 *  <p> No metódo run é criado um for, o primeiro sendo inicialmente o metodo de sincronização com a Thread Leste-Oeste.
 *  Inicializando o contador, o qual conta a quantidade de carros esperando a abertura do semaforo na direção Leste-Oeste
 *  e setando o metodo setCarros(), afim de o semaforo abrir o lock para direção Norte-Sul. Além disso, o for é o 
 *  temporizador do semaforo aberto para direção Norte-Sul. Por fim, há o fechamento do semaforo para direção Norte-Sul. </p>   
 *  @since 1.0
 */         
     public void run(){
        try{
            for (int i = 0; i < 40; i++) {
                System.out.println(carro + " por " + (40 - (i + 1)) + " segundos!");
                Thread.sleep(500);
                cont = cont + 1;
                System.out.println("Quantidade de carros esperando na via Leste-Oeste: " + cont);
                if (cont > 20 ){
                    System.out.println("Acelerando o semaforo, pois há mais de 20 carros esperando "
                            + "via Leste-Oeste");
                    Thread.sleep(100);
                    if(cont == 40) {
                        carros.setCarros(carro);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
