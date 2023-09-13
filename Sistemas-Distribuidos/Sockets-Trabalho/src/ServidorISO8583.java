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
            System.out.println("Servidor rodando na porta: " + porta);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Dados recebidos ");
                    double valorDaTransacao = 50.0;
                    Cartao cartao = cartoes.get(0);
                    synchronized (lock) {
                        if (cartao.getSaldo() >= valorDaTransacao) {
                            Transacao transacaoAprovada = new Transacao(valorDaTransacao, "20230912", "123456", "RedeA", "Credito", "12345", "00");
                            String nsu = String.format("%010d", nsuCounter);
                            nsuCounter++;
                            transacaoAprovada.setNsu(nsu);
                            cartao.setSaldo(cartao.getSaldo() - valorDaTransacao);
                            enviarResposta(clientSocket, transacaoAprovada);
                        } else {
                            Transacao transacaoRecusada = new Transacao(valorDaTransacao, "20230912", "123456", "RedeA", "Credito", "12345", "51");
                            String nsu = String.format("%010d", nsuCounter);
                            nsuCounter++;
                            transacaoRecusada.setNsu(nsu);
                            enviarResposta(clientSocket, transacaoRecusada);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void enviarResposta(Socket socket, Transacao transacao) throws IOException {
        try (OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true)) {
            MensagemISO8583 mensagem = new MensagemISO8583();
            mensagem.setCampo(1, "0200");
            mensagem.setCampo(2, "1234567890123456");
            mensagem.setCampo(3, String.format("%.2f", transacao.getValor()));
            mensagem.setCampo(4, transacao.getData());
            mensagem.setCampo(5, transacao.getHora());
            mensagem.setCampo(6, transacao.getRedeTransmissora());
            mensagem.setCampo(7, transacao.getFormaPagamento());
            mensagem.setCampo(8, transacao.getNsu());
            mensagem.setCampo(9, transacao.getCodigoResposta());
            String mensagemFormatada = mensagem.formatarMensagem();
            writer.println(mensagemFormatada);
        }
    }
}
