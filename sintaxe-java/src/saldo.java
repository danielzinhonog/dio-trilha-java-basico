import java.util.Locale;
import java.util.Scanner;

public class saldo {
    public static void main(String[] args) {
        // Usa o Locale padrão americano para aceitar ponto como separador decimal
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double saldoInicial = scanner.nextDouble();
        double transacao1 = scanner.nextDouble();
        double transacao2 = scanner.nextDouble();
        double transacao3 = scanner.nextDouble();

        double saldoFinal = saldoInicial + transacao1 + transacao2 + transacao3;

        // Exibe apenas o número, com duas casas decimais
        System.out.printf("%.2f\n", saldoFinal);

        scanner.close();
    }
}