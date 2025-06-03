import java.io.*;

public class TesteArquivo {
    public static void main(String[] args) {
        try {
            File pasta = new File("data");
            if (!pasta.exists()) {
                boolean criado = pasta.mkdirs();
                System.out.println("Pasta criada? " + criado);
            }

            File arquivo = new File(pasta, "tarefas.csv");
            FileWriter fw = new FileWriter(arquivo, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("1;Teste;Descrição do teste");
            pw.close();

            System.out.println("Arquivo criado e linha gravada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
