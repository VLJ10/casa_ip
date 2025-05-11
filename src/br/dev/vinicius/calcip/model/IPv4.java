package br.dev.vinicius.calcip.model;



public class IPv4 {
    String ip;
    
    //Divide o Ip em partes usando o ponto como separador
    String[] octetos = ip.split("\\.");
    
    //Criando as variaveis para guardar cada octeto 
    private String oc1 = octetos[0];
    private String oc2 = octetos[1];
    private String oc3 = octetos[2];
    private String oc4 = octetos[3];
    
    //convertendo o Oc1 para int 
    int validOc1 = Integer.parseInt(octetos[0]);
    
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return ip;
	}
	
}
