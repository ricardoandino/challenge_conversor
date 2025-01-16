import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        seleccionMoneda sm = new seleccionMoneda();
        sm.convertirMoneda("HNL","USD",100);


        while (true){
            System.out.println("****************************");
            System.out.println("Seleccione la conversion que desea realizar");
            System.out.println("1.Lempira =>> Dolares");
            System.out.println("2.Dolares =>> Lempira");
            System.out.println("3.Lempira =>> Peso argentino");
            System.out.println("4.Peso argentino =>> Lempira");
            System.out.println("5.Lempira =>> Peso colombiano");
            System.out.println("6.Peso colombiano =>> Lempira");
            System.out.println("0.Salir");
            int eleccion = lectura.nextInt();

            if (eleccion == 0) {
                System.out.println("\nSaliendo del programa...");
                break;
            }

            System.out.println("Ingrese la cantidad que desea convertir: ");
            double cantidadConvertir = lectura.nextDouble();

            switch (eleccion){
                case 1:
                sm.convertirMoneda("HNL","USD",cantidadConvertir);
                    break;
                case 2:
                    sm.convertirMoneda("USD","HNL",cantidadConvertir);
                    break;
                case 3:
                    sm.convertirMoneda("HNL","ARS",cantidadConvertir);
                    break;
                case 4:
                    sm.convertirMoneda("ARS","HNL",cantidadConvertir);
                    break;
                case 5:
                    sm.convertirMoneda("HNL","COP",cantidadConvertir);
                    break;
                case 6:
                    sm.convertirMoneda("COP","HNL",cantidadConvertir);
                    break;
            }
            System.out.println("****************************\n");
        }

    }
}
