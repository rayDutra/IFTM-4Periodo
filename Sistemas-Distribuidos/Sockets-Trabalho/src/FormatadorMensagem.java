public class FormatadorMensagem {
    public static String formatarMensagem200() {
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

    public static String formatarMensagem210() {
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
}
