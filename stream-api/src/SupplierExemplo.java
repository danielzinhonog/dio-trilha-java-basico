import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

//Representa uma operação que não aceita nenhuma argumento e retorna um resultado do tipo T.
//É comumente usada para criar ou fornecer novos objetos de uma determinado tipo.

public class SupplierExemplo{
    public static void main(String[] args) {
        //Usar o Supplier com expressao lambda para fornecer uma saudação personalizada
        Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

        //Usar o Supplier para obter uma lista com 5 saudações
        List<String> listaSaudacoes = Stream.generate(() -> "Olá, seja bem-vindo(a)!")
        .limit(5)
        .toList();

        //Imprimir as saudações geradas
        listaSaudacoes.forEach(System.out::println);
    }
}