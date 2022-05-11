package probandoclases;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

	public class Cajero {
		
		/*
		 * PARTE DE LOS DATOS DEL USUARIO
		 */
		 private String nombre;
		 private String apellido;
		 private String din;
		 private String email;
		 private double saldo=10000.0D;
		 private String telefono;
		 private String numcuenta;
				 
		 /**
			 * @param nombre
			 * @param apellido
			 * @param din
			 * @param email
			 * @param saldo
			 */
		 
		 
			public Cajero(String nombre, String apellido, String telefono,String email, double saldo) {
				super();
				this.nombre = nombre;
				this.apellido = apellido;
				this.telefono=telefono;
				this.email = email;
				this.saldo = saldo;
			}

		/**
		 * @param nombre
		 * @param apellido
		 * @param email
		 * @param saldo
		 * @param telefono
		 * @param numcuenta
		 * @param dni
		 */
		public Cajero(String nombre, String apellido, String email, double saldo, String telefono, String numcuenta
				) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.saldo = saldo;
			this.telefono = telefono;
			this.numcuenta = numcuenta;
			}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getApellido() {
			return apellido;
		}

		public String getNumcuenta() {
			return numcuenta;
		}

		public void setNumcuenta(String numcuenta) {
			this.numcuenta = numcuenta;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		
		

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		@Override
		public String toString() {
			return "Nonbre :" + getNombre();
		}

		







		/*
		 * ESTA ES LA PARTE PARA EL CONTROLDE ACCESO
		 */
		Scanner lector;
		int bandera = 1;
		int numero; // Guardaremos la opcion del usuario
		final int OPORTUNIDADES = 3;
		int contador = 1;
		
		final String  MIDNI="16041686Z";
		String dni;
		boolean dnicorrecto;
		String password="admin";
		
		private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
		private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
		private static final String[] INVALIDOS = new String[] { 	"00000000T",
																	"00000001R", 
																	"99999999R" };
		public int opcion=1;

		public Cajero() { // CONSTRUCTOR POR DEFECTO

		}
	
		
		public void mostrarMenu() {
		
			do {
				System.out.println("\n\t\t1. CONSULTAR SALDO");
				System.out.println("\t\t2. CONSULTAR CUENTA");
				System.out.println("\t\t3. INGRESAR DINERO");
				System.out.println("\t\t4. SACAR DINERO");
				System.out.println("\t\t5. CONSULTAR DATOS DEL TITULAR");
				System.out.println("\t\t6. Salir");
				
				lector = new Scanner(System.in);
				try {
					
					System.out.printf("\n\t\tSELECCIONA TU OPCIÓN: ");
					opcion = lector.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("\n\t\tSELECCIONADO CONSULTAR SALDO");
						consultarSaldo();
						
						break;
					case 2:
						System.out.println("\n\t\tSELECCIONADO CONSULTAR CUENTA");
						consultarCuenta();
						break;
					case 3:
						System.out.println("\n\t\tSELECCIONADO INGRESAR DINERO ");
						ingresarDinero();
						break;
					case 4:
						System.out.println("\n\t\tSELECCIONADO SACAR DINERO");
						sacarDinero();
						break;

					case 5:
						System.out.println("\n\t\tHAS SELCCIONADO CONSULTAR DATOS DEL TITULAR");
						consultarTitular();
						break;
					case 6:
						System.out.println("\n\t\tHAS SELECCIONADO SALIR ADIOS");
						System.exit(-1);
						break;
					default:
						System.out.println("\n\t\tRECUERDA NÚMEROS ENTRE 1 Y 6");
					}
				} catch (InputMismatchException e) {
					System.out.println("\t\tDEBES INSERTAR UN NÚMERO");
					lector.next();
				}
			} while (opcion != 6);// Acaba el do while
			lector.close();
		}
		
		
		private void sacarDinero() {
			
			System.out.println("\t\tVAS A SACAR DINERO");
			lector = new Scanner(System.in);
			
				System.out.printf("\t\tCantidad de dinero: ");
				double cantidad  = lector.nextDouble();
				this.saldo=this.saldo-cantidad;
				System.out.println("\t\tTu saldo es "+this.getSaldo());
			
		}

		private void ingresarDinero() {
			System.out.println("\t\tVAS A INGRESAR DINERO");
			lector = new Scanner(System.in);
			
				System.out.printf("\t\tCantidad de dinero: ");
				double cantidad  = lector.nextDouble();
				this.saldo=this.saldo+cantidad;
				System.out.println("\t\tTu saldo es "+this.getSaldo());
			
		}

		private void consultarSaldo() {
			System.out.println("\t\tSaldo " + this.getSaldo());
		}

		private String getsaldo() {
			// TODO Auto-generated method stub
			return null;
		}

		private void consultarTitular() {
	
			System.out.println("\t\tNombre "+ this.getNombre() +
					" Apelido " + this.getApellido()+
					" Saldo " + this.getSaldo()+
					" Teléfono " + this.getTelefono());
		}
			private void consultarCuenta() {
				
				System.out.println("\t\tSaldo " + this.getSaldo()+
						" Número cuenta " + this.getNumcuenta());
	
}

		public void validarDatos() {

			do {

				/// COMPROBACIÓN DNI

				dni = JOptionPane.showInputDialog(null, "Introduce el Dni", "MÉTODO PARA EL DNI",
						JOptionPane.QUESTION_MESSAGE);

				if (comprobarDni(dni)) {

					JOptionPane.showMessageDialog(null, "KAIXO " + dni, "DNI CORRECTO", JOptionPane.WARNING_MESSAGE);
					dnicorrecto = true;
					System.out.println("\t\tDNI CORRECTO");

				} else {
					JOptionPane.showMessageDialog(null, "DNI INCORRECTO ", "DNI INCORRECTO",
							JOptionPane.WARNING_MESSAGE);
					dnicorrecto = false;
				}

				password = JOptionPane.showInputDialog(null, "Introduce CLAVE", "MÉTODO PARA LA CLAVE",
						JOptionPane.QUESTION_MESSAGE);

				if ((dnicorrecto == false || password != "admin") && contador == 2) {
					System.out.println("\t\tULTIMA OPORTUNIDAD");

				} else if ((dnicorrecto == false || password != "admin") && contador == 3) {
					System.out.println("\t\tHAS GASTADO LOS " + OPORTUNIDADES + " INTENTOS ADIOS");
					System.exit(-1);
				} else if (password.equalsIgnoreCase("admin") && dnicorrecto == true) {

					System.out.println("\t\tCONTRASEÑA CORRECTA");
					bandera = 0;
				}

				contador++;

			} while (contador < 4 && bandera == 1);	
		}
		
		public boolean comprobarDni(String dni) {

			if (dni == null) { // Si el nombre está vacio devuelve false
				return false;
			}

			return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
					&& REGEXP.matcher(dni).matches() // (2)
					&& dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23) // (3)
					&& dni.equalsIgnoreCase(MIDNI);
		}// Acabo el mentodo de comprobarDni

	public static void main(String[] args) {
		
		Cajero  cajero =new Cajero(	"Gorka",
									"Ortega", 
									"gor_australia@yahoo.es", 
									50000.0,"TELEFONO","número_cuenta");
		
		cajero.validarDatos();
		
		cajero.mostrarMenu();
		
			
	}

}
