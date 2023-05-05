package Trabalho02;

/**
 * Thread que contem a direção Leste-Oeste do cruzamento, em que os carros aguardam o sinal abrir
 * @author Nicolas
 */
public class Leste_Oeste extends Thread{
    
    private Semaforo carros;

/**
* <p> Criação de dois contadores, o primeiro contador funciona como forma de sincronismo com a Thread Norte-Sul
* já o segundo contador funciona como a quantidade de carros esperando na via Norte-Sul </p>
**/
    int cont = 0;
    int cont2 = 0;
 
/**
 * <p> Classe Leste-Oeste recebe a variavel carros da classe Semaforo com a intenção de realizar a sincronização </p>
 */
    public Leste_Oeste (Semaforo carros) {
        this.carros = carros;
    }

/**
 *  <p> No metódo run é criado dois for, o primeiro sendo inicialmente o metodo de sincronização com a Thread Norte-Sul.
 *  Inicializando o primeiro contador e recebendo o metodo getCarros(), afim de o semaforo abrir o lock para direção
 *  Leste-Oeste. Logo em seguida, há o segundo for, o qual é o temporizador do semaforo aberto para direção Leste-Oeste
 *  e o segundo contador, o qual representa a quantidade de carros esperando na direção Norte-Sul. Por fim, há o fechamento
 *  do semaforo para direção Leste-Oeste. </p>   
 *  @since 1.0
 */     
    public void run(){
        try{
            for (int i = 0; i < 40; i++) {
                cont = cont + 1;
                Thread.sleep(500);
                if(cont == 40) {
                    System.out.println(this.carros.getCarros() + " agora esta fechado e esta aberta para via Leste-Oeste");
                    Thread.sleep(100);
                    for (int j = 0; j < 40; j++) {
                        System.out.println("Semaforo aberto para via Leste-Oeste por " + (40 - (j + 1)) + " segundos!");
                        Thread.sleep(500);
                        cont2 = cont2 + 1;
                        System.out.println("Quantidade de carros esperando na via Norte-Sul: " + cont2);
                        if (cont2 > 20 ){
                            System.out.println("Acelerando o semaforo, pois há mais de 20 carros esperando "
                                + "na via Norte-Sul");
                            Thread.sleep(100);
                        if(cont2 == 40) {
                            System.out.println("Via Leste-Oeste fechada! Abrindo para via Norte-Sul ");
                        }
                }
            }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
