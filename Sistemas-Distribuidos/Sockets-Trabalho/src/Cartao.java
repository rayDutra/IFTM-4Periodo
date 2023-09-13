class Cartao {
    private String numero;
    private String nomeCliente;
    private double saldo;

    public Cartao(String numero, String nomeCliente, double saldo) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double v) {
    }
}
