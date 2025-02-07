package POO2;

import java.util.Scanner;

public class MenuCuenta {
    public static void main(String[] args) {
        menu();


    }
    public static void menu(){
        Persona[] personas=new Persona[10];
        Scanner scan=new Scanner(System.in);
        int numPersonas=0;
        int opccion=0;
        do {

            System.out.println("Vienvenudo a caixamar, que desea hacer \n" +
                    "1.Crear usuario\n" +
                    "2.Crear una cuenta asociada al usuario\n" +
                    "3.Mostrar datos del usuario\n" +
                    "4.Recibir nomina mensual de una persona\n" +
                    "5.Recibir un pago\n" +
                    "6.Relaizar transferencia entre cuentas\n" +
                    "7.Imprimir las personas morosas");
            opccion= scan.nextInt();
            switch (opccion){
                case 1:
                    if (numPersonas < 10) {
                        System.out.print("Ingrese el DNI de la persona: ");
                        String dni = scan.next();
                        personas[numPersonas] = new Persona(dni);
                        numPersonas++;
                        System.out.println("Persona creada exitosamente.");
                    } else {
                        System.out.println("No se pueden agregar más personas.");
                    }
                    System.out.println("Usuario creado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el DNI de la persona: ");
                    String dni = scan.next();
                    boolean cuentaEncontrada=false;
                    for (int i=0;i<numPersonas || !cuentaEncontrada;i++){
                        if (personas[i] !=null &&personas[i].getDni().equals(dni)){
                            System.out.println("La cuenta existe");
                            personas[i].añadirCuenta(dni);
                            cuentaEncontrada=true;
                        }else{
                            System.out.println("Este usuario no existe");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el DNI de la persona: ");
                    dni = scan.next();
                    cuentaEncontrada=false;
                    for (int i=0;i<numPersonas || !cuentaEncontrada;i++){
                        if (personas[i] !=null && personas[i].getDni().equals(dni)){
                            for (int j=0;personas[i].getCuentas()[j]!=null ;j++){
                                System.out.println("Cuenta "+(j+1)+": " + personas[i].getCuentas()[j].getNumCuenta() +
                                        ", Saldo: " + personas[i].getCuentas()[j].getSaldo());
                            }
                            cuentaEncontrada=true;
                        }else{
                            System.out.println("Este usuario no existe");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el DNI de la persona: ");
                    String dniNomina = scan.next();
                    System.out.print("Ingrese el número de cuenta: ");
                    String numCuentaNomina = scan.next();
                    System.out.print("Ingrese el monto de la nómina: ");
                    double montoNomina = scan.nextDouble();
                    boolean nominaDepositada = false;

                    for (int i = 0; i < numPersonas && !nominaDepositada; i++) {
                        if (personas[i] != null && personas[i].getDni().equals(dniNomina)) {
                            for (int j = 0; j < 3 && !nominaDepositada; j++) {
                                if (personas[i].getCuentas()[j] != null &&
                                        personas[i].getCuentas()[j].getNumCuenta().equals(numCuentaNomina)) {
                                    personas[i].getCuentas()[j].recibirAbono(montoNomina);
                                    System.out.println("Nómina depositada correctamente.");
                                    nominaDepositada = true;
                                }
                            }
                        }
                    }

                    if (!nominaDepositada) {
                        System.out.println("No se encontró la cuenta.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el DNI de la persona: ");
                    dni = scan.next();
                    System.out.print("Ingrese el número de cuenta: ");
                    numCuentaNomina = scan.next();
                    System.out.print("Ingrese el monto de la nómina: ");
                    double pago= scan.nextDouble();
                    boolean pagoenviado = false;

                    for (int i = 0; i < numPersonas && !pagoenviado; i++) {
                        if (personas[i] != null && personas[i].getDni().equals(dni)) {
                            for (int j = 0; j < 3 && !pagoenviado; j++) {
                                if (personas[i].getCuentas()[j] != null &&
                                        personas[i].getCuentas()[j].getNumCuenta().equals(numCuentaNomina)) {
                                    personas[i].getCuentas()[j].pagarRecibos(pago);
                                    System.out.println("Pagado correctamente-");
                                    pagoenviado = true;
                                }
                            }
                        }
                    }

                    if (!pagoenviado) {
                        System.out.println("No se encontró la cuenta.");
                    }
                    break;
                case 6: // Realizar transferencia entre cuentas
                    System.out.print("Ingrese el DNI de la persona que envía dinero: ");
                    String dniOrigen = scan.next();
                    System.out.print("Ingrese el número de cuenta origen: ");
                    String cuentaOrigen = scan.next();
                    System.out.print("Ingrese el DNI de la persona que recibe dinero: ");
                    String dniDestino = scan.next();
                    System.out.print("Ingrese el número de cuenta destino: ");
                    String cuentaDestino = scan.next();
                    System.out.print("Ingrese el monto a transferir: ");
                    double montoTransferencia = scan.nextDouble();

                    boolean cuentaOrigenEncontrada = false;
                    boolean cuentaDestinoEncontrada = false;
                    Cuenta cuentaO = null;
                    Cuenta cuentaD = null;

                    // Buscar la cuenta de origen
                    for (int i = 0; i < numPersonas && !cuentaOrigenEncontrada; i++) {
                        if (personas[i] != null && personas[i].getDni().equals(dniOrigen)) {
                            for (int j = 0; j < 3 && !cuentaOrigenEncontrada; j++) {
                                if (personas[i].getCuentas()[j] != null &&
                                        personas[i].getCuentas()[j].getNumCuenta().equals(cuentaOrigen)) {
                                    cuentaO = personas[i].getCuentas()[j];
                                    cuentaOrigenEncontrada = true;
                                }
                            }
                        }
                    }

                    // Buscar la cuenta de destino
                    for (int i = 0; i < numPersonas && !cuentaDestinoEncontrada; i++) {
                        if (personas[i] != null && personas[i].getDni().equals(dniDestino)) {
                            for (int j = 0; j < 3 && !cuentaDestinoEncontrada; j++) {
                                if (personas[i].getCuentas()[j] != null &&
                                        personas[i].getCuentas()[j].getNumCuenta().equals(cuentaDestino)) {
                                    cuentaD = personas[i].getCuentas()[j];
                                    cuentaDestinoEncontrada = true;
                                }
                            }
                        }
                    }

                    // Validar y realizar la transferencia
                    if (!cuentaOrigenEncontrada) {
                        System.out.println("La cuenta de origen no fue encontrada.");
                    } else if (!cuentaDestinoEncontrada) {
                        System.out.println("La cuenta de destino no fue encontrada.");
                    } else if (cuentaO.getSaldo() < montoTransferencia) {
                        System.out.println("Saldo insuficiente en la cuenta de origen.");
                    } else {
                        cuentaO.setSaldo(cuentaO.getSaldo() - montoTransferencia);
                        cuentaD.setSaldo(cuentaD.getSaldo() + montoTransferencia);
                        System.out.println("Transferencia realizada con éxito.");
                        System.out.println("Nuevo saldo en cuenta origen: " + cuentaO.getSaldo());
                        System.out.println("Nuevo saldo en cuenta destino: " + cuentaD.getSaldo());
                    }
                    break;

                case 7:
                    boolean hayMorosos = false;
                    for (int i = 0; i < numPersonas; i++) {
                        if (personas[i] != null) {
                            for (int j = 0; j < 3; j++) {

                                if (personas[i].getCuentas()[j] != null && !hayMorosos) {
                                    if (personas[i].getCuentas()[j].getSaldo() < 0) {
                                        System.out.println("La persona con DNI " + personas[i].getDni() + " es morosa.");
                                        hayMorosos = true;
                                    }
                                }
                            }
                        }
                    }

                    if (!hayMorosos) {
                        System.out.println("No hay personas morosas.");
                    }
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    break;


            }
        }while(opccion!=8);

    }

}