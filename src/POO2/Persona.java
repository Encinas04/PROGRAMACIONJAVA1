package POO2;

import java.util.Scanner;

public class Persona {
    private String dni;
    private Cuenta[] cuentas;
    private int numeroCuentas;

    public Persona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3];
        this.numeroCuentas = 0;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }


    public void añadirCuenta(String dni){
        Scanner scan=new Scanner(System.in);
        if (dni.equals(this.dni)){
            if (numeroCuentas>=3){
                System.out.println("Lo sentimos pero usted ya ha superado el maximo de cuentas posible de 3");
            }else{
                System.out.println("Ingrese el numero de cuenta: ");
                String  numCuent= scan.next();
                cuentas[numeroCuentas]=new Cuenta(numCuent,0);
                numeroCuentas++;
            }
        }

    }
    public void esMorosa() {
        boolean morosa = false;
        for (int i = 0; i < numeroCuentas||morosa==false; i++) {
            if (cuentas[i].getSaldo() < 0) {
                morosa = true;
            }
        }
        if (morosa) {
            System.out.println("La persona es morosa.");
        } else {
            System.out.println("La persona no es morosa.");
        }
    }
}