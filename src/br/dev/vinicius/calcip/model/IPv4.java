package br.dev.vinicius.calcip.model;

import java.io.IOException;

public class IPv4 {
	private String ip;
	private String[] subMask;
	private String[] octetos;

	public void setIp(String ip) {
		this.ip = ip;
		
		this.subMask = ip.split("/");
		this.octetos = subMask[0].split("\\.");
	}

	public String getIp() {
		return ip;
	}

	// Criando as variaveis para guardar cada octeto
	private String oc1 = octetos[0];
	private String oc2 = octetos[1];
	private String oc3 = octetos[2];
	private String oc4 = octetos[3];

	// convertendo o Oc1 para int
	public void verificarClasseIp() {
		if (octetos == null || octetos.length != 4) {
            System.out.println("Endereço IP inválido");
            return;
        }
		
		try {
			int classeDoIp = Integer.parseInt(oc1);
			
			if (classeDoIp < 127) {
				System.out.print("IP classe A");
			} else if(classeDoIp >= 128 && classeDoIp <= 191){
				System.out.print("IP classe B");
			} else if(classeDoIp >= 192 && classeDoIp <= 223){
				System.out.print("IP classe C");
			} else {
				System.out.print("Esse endereço de ip é reservado para outras atividades");
			}
			
		} catch (NullPointerException erro) {
			System.out.print(erro.getMessage());
		} catch (Exception erro) {
			System.out.print(erro.getMessage());
		}
	}

}


