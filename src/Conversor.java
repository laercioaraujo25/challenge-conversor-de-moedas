import com.google.gson.JsonObject;

public class Conversor {

    private static final String CHAVE = "SUA_CHAVE_API";
    private static final String URL = "https://v6.exchangerate-api.com/v6/";
    private static final String P = "/pair/";
    private static final String L = "/latest/";

    private static final String[] MOEDAS = {
            "ARS", "BRL", "CLP", "EUR", "JPY", "USD", "CNH"
    };

    // Converter para todas as moedas
    public static void converterTodas(String moedaOrigem, double valorBase) {

        System.out.println("\nConvertendo " + valorBase + " " +
                moedaOrigem + " para todas as moedas:\n");

        for (String moedaDestino : MOEDAS) {

            if (moedaDestino.equalsIgnoreCase(moedaOrigem))
                continue;

            String urlFinal = URL + CHAVE + P + moedaOrigem + "/" + moedaDestino + "/" + valorBase;
            JsonObject resposta = Conexao.getJson(urlFinal);

            if (resposta != null && resposta.has("conversion_result")) {
                double convertido = resposta.get("conversion_result").getAsDouble();

                System.out.printf("%s → %s : %.4f%n",
                        moedaOrigem, moedaDestino, convertido);

                Historico.adicionar(valorBase + " " + moedaOrigem +
                        " → " + moedaDestino + " = " + convertido);

            } else {
                System.out.println("Erro ao converter para " + moedaDestino);
            }
        }
    }

    // Converter para BRL
    public static void converterParaBRL(String origem, double valor) {

        String url = URL + CHAVE + P + origem + "/BRL/" + valor;
        JsonObject resposta = Conexao.getJson(url);

        if (resposta != null && resposta.has("conversion_result")) {
            double convertido = resposta.get("conversion_result").getAsDouble();

            System.out.println("Valor convertido: R$ " + convertido);

            Historico.adicionar(valor + " " + origem +
                    " → BRL = " + convertido);
        }
    }

    // Converter entre duas moedas
    public static void converterEntre(String m1, String m2, double v) {

        String url = URL + CHAVE + P + m1 + "/" + m2 + "/" + v;
        JsonObject resposta = Conexao.getJson(url);

        if (resposta != null && resposta.has("conversion_result")) {
            double resultado = resposta.get("conversion_result").getAsDouble();

            System.out.println("Resultado: " + resultado + " " + m2);

            Historico.adicionar(v + " " + m1 + " → " + m2 +
                    " = " + resultado);
        }
    }
}

