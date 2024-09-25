import java.text.DecimalFormat;

/*Classe Contabancaria que define seus atributos como privados para serem acessado 
 * apenas de dentro da classe, e também já define que o atributo df será o formato de retorno dos valores.*/
public class ContaBancaria {
	private double saldo = 0;
	private int consulta;
    private DecimalFormat df = new DecimalFormat("#0.00");
	
	
    /*Construtor da classe conta, onde soma o valor atual do saldo que é 0 com o valor informado na classe Main
     * E informa que o número de consultas atual é 0.*/
	public ContaBancaria(double valor) {
		this.saldo += valor;
		this.consulta = 0;
	}
	
	/*Método que faz os depósitos na conta, e já cobra a taxa de 1%, mostrando a confirmação no terminal.*/
	public void deposito(double deposito) {
			double taxaDeposito = deposito * 0.01;
			saldo += (deposito - taxaDeposito);
			System.out.println("Depósito de R$" + df.format(deposito) + " realizado com sucesso. Taxa de 1% no valor " + df.format(taxaDeposito) + " aplicada.\n");
			System.out.println("Saldo atual de R$" + df.format(getSaldo()) + "\n");
	}
	
	/*Método que faz os saques na conta, e já cobra a taxa de 0,5%, mostrando a confirmação no terminal.*/
	public void saque(double saque) {
		double taxaSaque = saque * 0.005;
		saldo -= (saque + taxaSaque);
		System.out.println("Saque de R$" + df.format(saque) + " realizado com sucesso. Taxa de 0,5% no valor de " + df.format(taxaSaque) + " aplicada.\n");
		System.out.println("Saldo atual de R$" + df.format(getSaldo()) + "\n");
	}
	
	/*Método de consulta, onde dentro da condição if verifica se o restante da divisão do número da consulta atual é igual a 0,
	 * caso seja igual a zero significa que é a 5ª consulta e é cobrada a taxa e informada no terminal, e em seguida é zerada
	 * a quantidade de consultas, para se caso ocorra mais consulta o cálculo seja realizado novamente e cobrada outra taxa.*/
    public void consulta() {
        consulta++;
        
        if (consulta % 5 == 0) {
            saldo -= 0.10;
            System.out.println("Taxa de 0,10 centavos cobrada pela 5ª consulta.\n");
            consulta = 0;
        }
        
        System.out.println("Saldo atual de R$" + df.format(getSaldo()) + "\n");
    }
    
    /*Getter para encapsulamento do valor do saldo, para quando ser usado para mostrar o saldo 
     * no terminal, retornar o valor atual do momento*/
    public double getSaldo() {
        return saldo;
    }

}
