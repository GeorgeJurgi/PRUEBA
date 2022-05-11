package ejercicios_E;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cajero_E16_2 {

	public Cajero_E16_2() { // CONSTRUCTOR POR DEFECTO

		Scanner lector = new Scanner(System.in);
		int bandera = 1;
		int numero; // Guardaremos la opcion del usuario
		final int OPORTUNIDADES = 3;
		int contador = 1;
		int opcion=1;

		do {
			System.out.printf("\n\t\tINTRODUCE UN NÚMERO ");
			numero = lector.nextInt();

			if (numero != 66 && contador == 2) {
				System.out.println("\t\tULTIMA OPORTUNIDAD");

			} else if (numero != 66 && contador == 3) {
				System.out.println("\t\tHAS GASTADO LOS " + OPORTUNIDADES + " INTENTOS ADIOS");
				System.exit(-1);
			} else if (numero == 66) {
				bandera = 0;
			}

			contador++;

		} while (contador < 4 && bandera == 1);

		System.out.println("\n\t\tBIENVENIDO " + numero);

		
		do {
			System.out.println("\n\t\t1. CONSULTAR SALDO");
			System.out.println("\t\t2. CONSULTAR CUENTA");
			System.out.println("\t\t3. INGRESAR DINERO");
			System.out.println("\t\t4. SACAR DINERO");
			System.out.println("\t\t5. CONSULTAR TITULAR");
			System.out.println("\t\t6. Salir");

			try {

				System.out.printf("\t\tSELECCIONA TU OPCIÓN: ");
				opcion = lector.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("\t\tSELECCIONADO CONSULTAR SALDO");
					break;
				case 2:
					System.out.println("\t\tSELECCIONADO CONSULTAR CUENTA");
					break;
				case 3:
					System.out.println("\t\tSELECCIONADO INGRESAR DINERO ");
					break;
				case 4:
					System.out.println("\t\tSELECCIONADO SACAR DINERO");
					break;

				case 5:
					System.out.println("\t\tHAS SELCCIONADO CONSULTAR TITULAR");
					break;
				case 6:
					System.out.println("\t\tHAS SELECCIONADO SALIR ADIOS");
					System.exit(-1);
					break;
				default:
					System.out.println("\t\tRECUERDA NÚMEROS ENTRE 1 Y 6");
				}
			} catch (InputMismatchException e) {
				System.out.println("\t\tDEBES INSERTAR UN NÚMERO");
				lector.next();
			}
		} while (opcion != 6);// Acaba el do while

		lector.close();
	}
}
