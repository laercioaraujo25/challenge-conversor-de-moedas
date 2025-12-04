import java.util.ArrayList;
import java.util.List;

public class Historico {

    private static final List<String> registros = new ArrayList<>();

    public static void adicionar(String registro) {
        registros.add(registro);
    }

    public static void mostrar() {
        System.out.println("==============================================");
        System.out.println("             📜 HISTÓRICO DE CONVERSÕES       ");
        System.out.println("==============================================");

        if (registros.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.\n");
            return;
        }

        for (int i = 0; i < registros.size(); i++) {
            System.out.println((i + 1) + " ▸ " + registros.get(i));
        }

        System.out.println("==============================================\n");
    }
}
