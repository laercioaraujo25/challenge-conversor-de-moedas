import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            Menu.mostrar();
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1 -> {
                    System.out.println("""
                            Moedas disponiveis
                            ARS - Peso argentino 
                            BRL - Real brasileiro 
                            CLP - Peso chileno 
                            EUR - Euro 
                            JPY - Iene Japonês 
                            USD - Dólar Americano 
                            CNH - Renminbi chinês offshore 
                    """ );
                    System.out.println("Digite a moeda de origem:");
                    String origem = entrada.next().toUpperCase();

                    System.out.println("Digite o valor:");
                    double valor = entrada.nextDouble();

                    Conversor.converterTodas(origem, valor);
                }

                case 2 -> {
                    System.out.println("Digite a moeda de origem:");
                    String origem = entrada.next().toUpperCase();

                    System.out.println("Digite o valor:");
                    double valor = entrada.nextDouble();

                    Conversor.converterParaBRL(origem, valor);
                }

                case 3 -> {
                    System.out.println("Moeda de origem:");
                    String m1 = entrada.next().toUpperCase();

                    System.out.println("Moeda destino:");
                    String m2 = entrada.next().toUpperCase();

                    System.out.println("Valor:");
                    double v = entrada.nextDouble();

                    Conversor.converterEntre(m1, m2, v);
                }

                case 4 -> Historico.mostrar();

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
