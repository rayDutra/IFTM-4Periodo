import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorISO8583 {
    private static List<Cartao> cartoes = new ArrayList<>();
    private static int nsuCounter = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        cartoes.add(new Cartao("1234567890123456", "Fernando José", 1000.0));
        cartoes.add(new Cartao("9876543210987654", "Claúdia Figueiredo", 500.0));
        cartoes.add(new Cartao("1111222233334444", "Amdanda Costa", 200.0));

        int porta = 4000;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor aguardando conexões na porta: " + porta);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
                    double valorDaTransacao = 50.0;
                    Cartao cartao = cartoes.get(0);
                    synchronized (lock) {
                        if (cartao.getSaldo() >= valorDaTransacao) {
                            Transacao transacaoAprovada = new Transacao(valorDaTransacao, "20230912", "123456", "RedeA", "Credito", "12345", "00");
                            String nsu = String.format("%010d", nsuCounter);
                            nsuCounter++;
                            transacaoAprovada.setNsu(nsu);
                            cartao.setSaldo(cartao.getSaldo() - valorDaTransacao);

                            String respostaEnviadaAoCliente = formatarResposta(transacaoAprovada);
                            enviarResposta(clientSocket, respostaEnviadaAoCliente);

                            System.out.println("Resposta enviada: " + respostaEnviadaAoCliente);
                        } else {
                            Transacao transacaoRecusada = new Transacao(valorDaTransacao, "20230912", "123456", "RedeA", "Credito", "12345", "51");
                            String nsu = String.format("%010d", nsuCounter);
                            nsuCounter++;
                            transacaoRecusada.setNsu(nsu);

                            String respostaEnviadaAoCliente = formatarResposta(transacaoRecusada);
                            enviarResposta(clientSocket, respostaEnviadaAoCliente);

                            System.out.println("Resposta enviada: " + respostaEnviadaAoCliente);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String lerMensagemDoCliente(Socket socket) throws IOException {
        return "";
    }

    private static void enviarResposta(Socket socket, String resposta) throws IOException {
        try (OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true)) {
            writer.println(resposta);
        }
    }

    private static String formatarResposta(Transacao transacao) {
        StringBuilder mensagemFormatada = new StringBuilder();
        if ("00".equals(transacao.getCodigoResposta())) {
            mensagemFormatada.append("05000000");
        } else {
            mensagemFormatada.append("05");
            mensagemFormatada.append(transacao.getCodigoResposta());
            mensagemFormatada.append("0000"); // Campos adicionais, se necessário
        }

        return mensagemFormatada.toString();
    }
}
