package br.dev.vinicius.calcip;

import br.dev.vinicius.calcip.model.IPv4;

public class Main {

	public static void main(String[] args) {
		
		IPv4 ip = new IPv4();
		ip.setIp("10.0.0.1/24");
		ip.getSeparMascara();
		ip.getOctetos();
		String sub = ip.decimalSubMask();
		
		System.out.println(sub);
	}

}
