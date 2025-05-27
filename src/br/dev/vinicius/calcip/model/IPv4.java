package br.dev.vinicius.calcip.model;

import java.io.IOException;
import java.util.Arrays;

public class IPv4 {
	private String ip;
	private String[] separMascara;
	private String[] octetos;
	
	private String oc1;
	private String oc2;
	private String oc3;
	private String oc4;
	
	public IPv4(String ip) {
		this.ip = ip;
		
		this.separMascara = ip.split("/");
		this.octetos = separMascara[0].split("\\.");
		
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
	
	public String getOc1() {
		return octetos != null && octetos.length > 0 ? octetos[0] : null;
	}
	public String getOc2() {
		return octetos != null && octetos.length > 0 ? octetos[1] : null;
	}
	public String getOc3() {
		return octetos != null && octetos.length > 0 ? octetos[2] : null;
	}
	public String getOc4() {
		return octetos != null && octetos.length > 0 ? octetos[3] : null;
	}

	

	// convertendo o Oc1 para int
	public String verificarClasseIp() {
		if (octetos == null || octetos.length != 4) {
            return "Endereço IP inválido";
        }
		
		try {
			int classeDoIp = Integer.parseInt(oc1);
			
			if (classeDoIp < 127) {
				System.out.print("IP classe A: ");
			} else if(classeDoIp >= 128 && classeDoIp <= 191){
				System.out.print("IP classe B: ");
			} else if(classeDoIp >= 192 && classeDoIp <= 223){
				System.out.print("IP classe C: ");
			} else {
				return "Esse endereço de ip é reservado para outras atividades";
			}
			
		} catch (NullPointerException erro) {
			System.out.print(erro.getMessage());
		} catch (Exception erro) {
			System.out.print(erro.getMessage());
		}
		return oc1;
	}
	@Override
	public String toString() {
		
		return "IPv4: " + ip + "\n" + "Separação da Mascara de sub-rede" + Arrays.toString(separMascara) + "\n"+ "Octetos:" + Arrays.toString(octetos) ;
	}

}


