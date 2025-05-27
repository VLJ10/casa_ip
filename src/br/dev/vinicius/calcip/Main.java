package br.dev.vinicius.calcip;

import br.dev.vinicius.calcip.model.IPv4;

public class Main {

	public static void main(String[] args) {
		
		IPv4 ip = new IPv4("190.168.2.50/24");	
		System.out.println(ip);
		ip.setIp("192.168.2.50/24");
		
		String classeIp = ip.verificarClasseIp();
		System.out.println(classeIp);
	}

}
