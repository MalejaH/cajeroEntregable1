import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    // variable y constantes
    int pinActual = 1512;
    double saldo = 100000;
    int intentos = 0;
    boolean cuentaBloqueada = false;

    // Auntenticación según los intentos
    while (intentos < 3){
        System.out.println("Ingrese su PIN: ");
        int pinIngresado = scanner.nextInt();

        if(pinIngresado == pinActual){
            System.out.println("BIENVENIDO");
            break;

        }else {
            intentos ++;
            System.out.println("PIN incorrecto ¡No, no,no! "+ intentos);

        }if (intentos == 3){
            cuentaBloqueada = true;
            System.out.println("CUENTA BLOQUEADA ¡RAROOO!");
        }
    }

    // si la cuenta ha sido bloqueada finalizará el programa
    if (cuentaBloqueada){
        scanner.close();
        return;

    }
    // Menú de cajero
    int opcion;
    do{
        System.out.println("BIENVENIDO A SU CAJERO");
        System.out.println("1. Consultar su saldo");
        System.out.println("2. Retirar saldo");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Enviar dinero");
        System.out.println("5. Cambiar PIN");
        System.out.println("6. SALIR");
        System.out.println("Selecionar una opción!");
        opcion = scanner.nextInt();

        // manejo de opciones 
        switch (opcion) {
            case 1:
                System.out.println("Este es tu saldo: $" + saldo);
                break;

            case 2:
                System.out.println("Que cantidad deseas retirar?: ");
                double retiro = scanner.nextDouble();
                if(retiro >= 0 && retiro <= saldo){
                    saldo -= retiro;
                    System.out.println("Sacaste dinero, tu saldo es de:"+ saldo);
                }else{
                    System.out.println("Cómo vas a retirar un saldo que no tienes?" + saldo);

                } 
                break;

            case 3:
                System.out.println ("Cúanto dinero vas a depositar?:" );
                double deposito = scanner.nextDouble();
                if( deposito > 0){
                    saldo += deposito;
                    System.out.println("Depositación exitosa!!!, su saldo es de: " + saldo );

                }else{
                    System.out.println("Ese valor no está disponible");

                }
                break;
            case 4:
                System.out.println("Ingrese el número de cuenta al que desea enviar dinero: ");
                String numeroDeCuenta = scanner.next();
                System.out.println ("¿Cúanto dinero vas a enviar?:" );
                int envio = scanner.nextInt();
                if(envio >= 0 && envio <= saldo){
                    saldo -= envio;
                    System.out.println("Envío exitoso,su envío fue de: "+ envio + "al número de cuenta: "+ numeroDeCuenta+ " su saldo es de: "+ saldo );
                }else {
                    System.out.println("Ese valor no está no disponible");
                }
                break;
            case 5:
            System.out.println("Ingrese su PIN actual: ");
            int pinCambio = scanner. nextInt(); //capturamos el número ingresado y se guarda en la variable piningresado 
            if (pinCambio == pinActual){ // verficamos los pines si son = podrá cambiar pin 
                System.out.println ("Ingrese su NUEVO pin: ");
                int nuevoPin = scanner.nextInt();
                if (nuevoPin == pinActual){
                    System.out.println("¡El PIN  debe ser diferente al anterior!");
                }else{
                    pinActual = nuevoPin;
                    System.out.println("Su pin se ha cambiado de  manera EXITOSA.");
                }
            }else{
                System.out.println("Pin INCORRECTO.");
            }
            break;
            case 6:
                System.out.println("HASTA PRONTO");
                break;
                default:
                System.out.println("¡Esa NO es una opción!");
                break; 
                
        }
    }while (opcion != 6);
    scanner.close();


    }
}
