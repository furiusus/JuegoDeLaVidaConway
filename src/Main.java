import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Reglas reglas = new Reglas();
        List<Celda> celdasPobladas = new ArrayList<>();
        for(int i=1;i<40;i++){
            Random random = new Random();
            Celda celda2 = new Celda(random.nextInt(10)+11,random.nextInt(10)+11);
            celdasPobladas.add(celda2);
        }

        try {
            Malla mallaTest = new Malla(30,30,celdasPobladas);
            mallaTest.pintarMalla();
            for (int m=1;m<=200;m++) {
                Thread.sleep(500);
                System.out.println("\n");
                Malla mallaTest2 = reglas.aplicarReglas(mallaTest);
                mallaTest = (Malla) mallaTest2.clone();
                mallaTest.pintarMalla();
            }
        }catch (NullPointerException | InterruptedException e ){
            System.out.println("Revisar si hay poblados, sin pueblos no hay expansion");
        }
    }
}

