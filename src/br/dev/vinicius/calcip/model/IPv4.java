package br.dev.vinicius.calcip.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class IPv4 {
	private String ip;
	private String[] separMascara;
	private String[] octetos;

	private String oc1;
	private String oc2;
	private String oc3;
	private String oc4;

	public IPv4() {
	}

	public IPv4(String ip) {
		if (ip == null || ip.isEmpty()) {
	        throw new IllegalArgumentException("Você informou o ip errado. /n Tente desse jeito xxx.xxx.xxx.xxx/xx");
	    }

	    this.ip = ip;
		this.ip = ip;

		this.separMascara = ip.split("/");
		this.octetos = separMascara[0].split("\\.");
		
		if (octetos == null || octetos.length != 4 ) {
			throw new IllegalArgumentException("Ip Invalido");
		} 
		for (String octeto : octetos) {
			try {
				
				int valor = Integer.parseInt(octeto);
				if(valor < 0 || valor > 255) {
					throw new IllegalArgumentException("Octeto fora do intervalo (0-255):" + octeto);
				}
			} catch (NumberFormatException erro) {
				 throw new IllegalArgumentException("Octeto inválido: " + octeto);
			}
		}

		this.oc1 = octetos[0];
		this.oc2 = octetos[1];
		this.oc3 = octetos[2];
		this.oc4 = octetos[3];

	}

	public void setIp(String ip) {
		this.ip = ip;

	}

	public String getIp() {
		return ip;
	}

	public String[] getSeparMascara() {
		this.separMascara = ip.split("/");
		return separMascara;
	}

	public void setSeparMascara(String[] separMascara) {
		this.separMascara = separMascara;
	}

	public String[] getOctetos() {
		this.octetos = separMascara[0].split("\\.");
		return octetos;

	}

	public void setOctetos(String[] octetos) {
		this.octetos = octetos;
	}

	public String getOc1() {
		this.oc1 = octetos[0];
		return octetos != null && octetos.length > 0 ? octetos[0] : null;
	}

	public String getOc2() {
		this.oc2 = octetos[1];
		return octetos != null && octetos.length > 0 ? octetos[1] : null;
	}

	public String getOc3() {
		this.oc3 = octetos[2];
		return octetos != null && octetos.length > 0 ? octetos[2] : null;
	}

	public String getOc4() {
		this.oc4 = octetos[3];
		return octetos != null && octetos.length > 0 ? octetos[3] : null;
	}
//	public String validacaoIp() {
//		if (oc1 == null) {
//			return "Endereço IP inválido";
//		}
//		if (oc2 == null) {
//			return "Endereço IP inválido";
//		}
//		if (oc3 == null) {
//			return "Endereço IP inválido";
//		}
//		if (oc4 == null) {
//			return "Endereço IP inválido";
//		}
//		
//		int octeto1 = Integer.parseInt(oc1);
//		int octeto2 = Integer.parseInt(oc2);
//		int octeto3 = Integer.parseInt(oc3);
//		int octeto4 = Integer.parseInt(oc4);
//		int cdri = Integer.parseInt(separMascara[1]);
//		
//		try {
//			
//			if (cdri == 1 && octeto1 >= 128) {
//			    throw new IllegalArgumentException("Ip Invalido. A mascará de sub-rede /1 só é dsponivel ate o ip 127.255.255.254");
//			} else if (){
//
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	// convertendo o Oc1 para int
	public String verificarClasseIp() {
		if (oc1 == null) {
			return "Endereço IP inválido";
		}
		int classeDoIp = Integer.parseInt(oc1);

		try {
			

			if (classeDoIp < 127) {
				return "IP Classe A: " + classeDoIp;
			} else if (classeDoIp >= 128 && classeDoIp <= 191) {
				return "IP Classe B: " + classeDoIp;
			} else if (classeDoIp >= 192 && classeDoIp <= 223) {
				return "IP Classe C: " + classeDoIp;
			} else {
				return "Esse endereço de ip é reservado para outras atividades";
			}

		} catch (NullPointerException erro) {
			erro.getMessage();
		} catch (Exception erro) {
			erro.getMessage();
		}
		return "" + classeDoIp;
	}

	// metodo conversor de máscara cidr para decimal
	public String decimalSubMask() {

		// conferindo se o usuario digitou o ip completo
		if (separMascara == null || separMascara.length != 2) {

			// mensagem de erro caso o usuario tenha digitado o ip errado
			throw new IllegalArgumentException("Máscara de sub-rede invalida.");
		}

		try {

			// Aqui foi criaada uma variavel para receber e converter para inteiro a mascará
			// cidr que
			// se encontra na segunda posição do vetor separMascara

			int decimal = Integer.parseInt(separMascara[1]);

			// Conferindo se a máscara de CIDR existe
			if (decimal < 0 || decimal > 32) {
				throw new IllegalArgumentException("Valor da máscara CIDR deve estar entre 0 e 32");
			}
			// mapeamento das máscaras decimais
			String[] mascaras = { "0.0.0.0", "128.0.0.0", "192.0.0.0", "224.0.0.0", "240.0.0.0", "248.0.0.0",
					"252.0.0.0", "254.0.0.0", "255.0.0.0", "255.128.0.0", "255.192.0.0", "255.224.0.0", "255.240.0.0",
					"255.248.0.0", "255.252.0.0", "255.254.0.0", "255.255.0.0", "255.255.128.0", "255.255.192.0",
					"255.255.224.0", "255.255.240.0", "255.255.248.0", "255.255.252.0", "255.255.254.0",
					"255.255.255.0", "255.255.255.128", "255.255.255.192", "255.255.255.224", "255.255.255.240",
					"255.255.255.248", "255.255.255.252", "255.255.255.254", "255.255.255.255" };

			// retorno na mascara decimal
			return mascaras[decimal];

		} catch (NumberFormatException erro) {
			throw new IllegalArgumentException("Valor decimal inválido: " + separMascara[1]);
		}

	}

	public String binSubMask() {

		if (separMascara == null || separMascara.length != 2) {

			// mensagem de erro caso o usuario tenha digitado o ip errado
			throw new IllegalArgumentException("Máscara de sub-rede invalida.");
		}
		
		try {
			
			int binario = Integer.parseInt(separMascara[1]);
			
			if (binario < 0 || binario > 32) {
				
				throw new IllegalArgumentException("Valor da máscara CIDR deve estar entre 0 e 32");
			}
			
			String[] mascaraBin = {"00000000.00000000.00000000.00000000","10000000.00000000.00000000.00000000","11000000.00000000.00000000.00000000",
					"11100000.00000000.00000000.00000000","11110000.00000000.00000000.00000000","11111000.00000000.00000000.00000000","11111100.00000000.00000000.00000000",
					"11111110.00000000.00000000.00000000","11111111.00000000.00000000.00000000","11111111.10000000.00000000.00000000","11111111.11000000.00000000.00000000",
					"11111111.11100000.00000000.00000000","11111111.11110000.00000000.00000000","11111111.11111000.00000000.00000000","11111111.11111100.00000000.00000000",
					"11111111.11111110.00000000.00000000","11111111.11111111.00000000.00000000","11111111.11111111.10000000.00000000","11111111.11111111.11000000.00000000",
                    "11111111.11111111.11100000.00000000","11111111.11111111.11110000.00000000","11111111.11111111.11111000.00000000","11111111.11111111.11111100.00000000",
					"11111111.11111111.11111110.00000000","11111111.11111111.11111111.00000000","11111111.11111111.11111111.10000000","11111111.11111111.11111111.11000000",
					"11111111.11111111.11111111.11100000","11111111.11111111.11111111.11110000","11111111.11111111.11111111.11111000","11111111.11111111.11111111.11111100",
					"11111111.11111111.11111111.11111110","11111111.11111111.11111111.11111111", };
			
			return mascaraBin[binario];
			
		} catch (NumberFormatException erro) {
			throw new IllegalArgumentException("Valor Binario não encontrado." + "/N" + "Certifique que a mascara CIDR esteja correta" + separMascara[1]);
		}
	}
	
	public String ipsDisponiveis() {
		
		if (separMascara == null || separMascara.length != 2) {

			// mensagem de erro caso o usuario tenha digitado o ip errado
			throw new IllegalArgumentException("Máscara de sub-rede invalida.");
		}
		
		try {
			
			int quantidade = Integer.parseInt(separMascara[1]);
			
            if (quantidade < 0 || quantidade > 32) {
				
				throw new IllegalArgumentException("Valor da máscara CIDR deve estar entre 0 e 32");
			}
            
            String[] quantidadeTotal = {"4.294.967.296","2.147.483.648","1.073.741.824","536.870.912","268.435.456","134.217.728","67.108.864",
            		"33.554.432","16.77.216","8.388.608","4.194.304","2.097.152","1.048.576","524.288","262.144","131.072","65.536","32.768",
            		"16.384","8.192","4.096","2.048","1.024","512","256","128","64","32","16","8","4","2","1"};
			
            return quantidadeTotal[quantidade];
            
		} catch (NumberFormatException erro) {
			throw new IllegalArgumentException("Erro Valor não encontrado" + "/n" + "Certifique que a mascara CIDR esteja correta" + separMascara[1]);
		}
		
	}

	@Override
	public String toString() {
		System.out.println("meu to string");

		return "IPv4: " + ip + "\n" + "Separação da Mascara de sub-rede" + Arrays.toString(separMascara) + "\n"
				+ "Octetos:" + Arrays.toString(octetos) + "\n";
	}

}
