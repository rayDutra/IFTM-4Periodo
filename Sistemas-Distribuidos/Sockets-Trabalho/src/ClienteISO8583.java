import java.io.*;
import java.net.*;

public class ClienteISO8583 {
    public static void main(String[] args) {
        String host = "localhost";
        int porta = 4000;

        try (Socket socket = new Socket(host, porta);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String mensagemISO8583 = criarMensagemISO8583();
            out.println(mensagemISO8583);
            String resposta = in.readLine();
            System.out.println("Resposta do servidor: " + resposta);
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + host);
        } catch (IOException e) {
            System.err.println("Erro de I/O para o host " + host);
        }
    }

    private static String criarMensagemISO8583() {
        String mensagem = "ISO8583_HEADER";
        mensagem += "0200";
        mensagem += "1234567890123456";
        mensagem += "100.00";
        mensagem += "20230912";
        mensagem += "123456";
        mensagem += "RedeA";
        mensagem += "Credito";
        mensagem += "12345";
        mensagem += "00";
        return mensagem;
    }
}