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

    public String formatarMensagem200() {
        StringBuilder mensagemFormatada = new StringBuilder();

        mensagemFormatada.append("0200");
        mensagemFormatada.append("2010");
        mensagemFormatada.append("104446");
        mensagemFormatada.append("0512");
        mensagemFormatada.append("40104");
        mensagemFormatada.append("4012310218451");
        mensagemFormatada.append("1");

        return mensagemFormatada.toString();
    }

    public String formatarMensagem210() {
        StringBuilder mensagemFormatada = new StringBuilder();

        mensagemFormatada.append("0210");
        mensagemFormatada.append("2000");
        mensagemFormatada.append("104400");
        mensagemFormatada.append("0512");
        mensagemFormatada.append("40104");
        mensagemFormatada.append("00");
        mensagemFormatada.append("02363");

        return mensagemFormatada.toString();
    }

    public static void main(String[] args) {
        MensagemISO8583 mensagem = new MensagemISO8583();

        String mensagemFormatada200 = mensagem.formatarMensagem200();
        System.out.println("Mensagem 200: " + mensagemFormatada200);

        String mensagemFormatada210 = mensagem.formatarMensagem210();
        System.out.println("Mensagem 210: " + mensagemFormatada210);
    }
}
