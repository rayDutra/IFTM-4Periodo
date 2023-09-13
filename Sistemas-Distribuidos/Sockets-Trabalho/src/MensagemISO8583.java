import java.util.HashMap;
import java.util.Map;

public class MensagemISO8583 {
    private Map<Integer, String> campos = new HashMap<>();
    public void setCampo(int numeroCampo, String valor) {
        campos.put(numeroCampo, valor);
    }
    public String getCampo(int numeroCampo) {
        return campos.get(numeroCampo);
    }
    public String formatarMensagem() {
        StringBuilder mensagemFormatada = new StringBuilder();

        for (int i = 0; i <= 127; i++) {
            String valorCampo = campos.get(i);

            if (valorCampo != null) {
                int comprimentoValor = valorCampo.length();

                mensagemFormatada.append(String.format("%04d", i));
                mensagemFormatada.append(String.format("%04d", comprimentoValor));
                mensagemFormatada.append(valorCampo);
            }
        }

        return mensagemFormatada.toString();
    }

    public static void main(String[] args) {
        FormatadorMensagem formatador200 = new FormatadorMensagem();
        String mensagemFormatada200 = formatador200.formatarMensagem200();
        System.out.println("Mensagem 200: " + mensagemFormatada200);
        FormatadorMensagem formatador210 = new FormatadorMensagem();
        String mensagemFormatada210 = formatador210.formatarMensagem210();
        System.out.println("Mensagem 210: " + mensagemFormatada210);
    }
}
