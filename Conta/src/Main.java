
public class Main {

	public static void main(String[] args) {
		
		/*Instancia a conta com o valor de saldo da conta, e realiza operações de deposito e saque.
		 * No for faz um loop de consultas para testar e cobrar a taxa de consulta após a 5ª consulta.*/
		ContaBancaria conta1 = new ContaBancaria(300);
		conta1.deposito(150);
		conta1.deposito(45.50);
		conta1.saque(78.30);
		conta1.saque(89.56);
		for (int i=0; i<5; i++) {
			conta1.consulta();
		}
		//Quebra de linha
		System.out.println("\n");
		
		/*Instancia outra conta com o valor de saldo, e realiza operações, mas nesse loop for
		 * a conta 13 consultas resultando em duas taxas de consulta sendo cobradas, feito assim
		 * para testar a limpa no número de consultas dentro do método Consulta da classe ContaBancaria.*/
		ContaBancaria conta2 = new ContaBancaria(5000);
		conta2.deposito(56);
		conta2.deposito(45.83);
		conta2.saque(78.40);
		conta2.saque(129.56);
		for (int i=0; i<12; i++) {
			conta2.consulta();
		}
	}

}
