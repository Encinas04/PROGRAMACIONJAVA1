package POO2;

public class Cuenta {
    private String numCuenta;
    private double saldo;

    public Cuenta(String numCuenta,double saldo){
        this.numCuenta=numCuenta;
        this.saldo=saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void consultarSaldo(){
        System.out.println("Su saldo actual es: "+getSaldo());
    }

    public void recibirAbono(double abono){
        setSaldo(this.saldo+abono);
    }
    public void pagarRecibos(double recibo){
        if (getSaldo()<recibo){
            System.out.println("Saldo insuficiente");
        }else{
            setSaldo(getSaldo()-recibo);
        }
        System.out.println("Tu saldo actual es de: "+getSaldo());
    }
}