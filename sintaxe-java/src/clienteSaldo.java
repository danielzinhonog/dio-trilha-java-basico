import java.util.Locale;
import java.util.Scanner;

public class clienteSaldo{

    public static void main(String[] args){
        // Usa Locale US para garantir entrada com ponto como separador decimal
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();

        // Classificação do cliente com base no saldo
        if (saldo < 0) {
            System.out.println("Negativado");
        } else if (saldo <= 500) {
            System.out.println("Baixo");
        } else {
            System.out.println("Confortavel");
        }

        scanner.close();
    }
}