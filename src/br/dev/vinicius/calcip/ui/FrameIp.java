package br.dev.vinicius.calcip.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.vinicius.calcip.model.IPv4;

public class FrameIp {
	
	private JLabel labelTitulo;
	private JLabel labelClasse;
	private JLabel labelSubDecimal;
	private JLabel labeltextDecimal;
	private JLabel labelSubBinario;
	private JLabel labeltextBinario;
	private JLabel labelQuantidade;
	private JTextField textIp;
	private JButton btnCalcular;
	private JButton btnLimpar;
	private Font labels = new Font("Fixedsys Regular", Font.PLAIN, 15);
	
	public FrameIp() {
		criarTela();
	}
	
	public void criarTela(){
		JFrame tela = new JFrame();
		tela.setSize(400, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		//Label Titulo
		labelTitulo = new JLabel("Caculadora Ip");
		labelTitulo.setBounds(100, 40, 200, 50);
		labelTitulo.setFont(new Font("Fixedsys Regular", Font.PLAIN, 30));
		
		//txt IP
		textIp = new JTextField();
		textIp.setBounds(45, 100, 300, 30);
		
		//Botão Calcular
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(45, 150, 100, 30);
		
		//BotãoLimpar
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(165, 150, 100, 30);
		
		//label Classe do ip
		labelClasse = new JLabel();
		labelClasse.setBounds(45, 200, 150, 30);
		labelClasse.setFont(labels);
		
		//label Sub Rede Decimal
		labeltextDecimal = new JLabel();
		labeltextDecimal.setBounds(45, 240, 270, 30);
		labeltextDecimal.setFont(new Font("Fixedsys Regular", Font.PLAIN, 14));
		
		//label Sub Rede Decimal
		labelSubDecimal = new JLabel();
		labelSubDecimal.setBounds(45, 270, 270, 30);
		labelSubDecimal.setFont(new Font("Fixedsys Regular", Font.PLAIN, 14));
		
		//Label texto Binario
		labeltextBinario = new JLabel();
		labeltextBinario.setBounds(45, 320, 350, 30);
		labeltextBinario.setFont(new Font("Fixedsys Regular", Font.PLAIN, 14));
		
		//label Sub Rede Binario
		labelSubBinario = new JLabel();
		labelSubBinario.setBounds(45, 360, 350, 30);
		labelSubBinario.setFont(new Font("Fixedsys Regular", Font.PLAIN, 14));
		
		
		//Label da Quantidade de Ips totais
		labelQuantidade = new JLabel();
		labelQuantidade.setBounds(45, 400, 350, 50);
		labelQuantidade.setFont(new Font("Fixedsys Regular", Font.PLAIN, 14));
		
		painel.add(labelTitulo);
		painel.add(textIp);
		painel.add(btnCalcular);
		painel.add(btnLimpar);
		painel.add(labelClasse);
		painel.add(labeltextDecimal);
		painel.add(labelSubDecimal);
		painel.add(labeltextBinario);
		painel.add(labelSubBinario);
		painel.add(labelQuantidade);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				String ip = textIp.getText();
				
				try {
					IPv4 ipv4 = new IPv4(ip);
					
					String classe = ipv4.verificarClasseIp();
					labelClasse.setText(classe);
					labeltextDecimal.setText("Mascará de Sub rede decimal: ");
					
					String decimal = ipv4.decimalSubMask();
					labelSubDecimal.setText(decimal);
					
					labeltextBinario.setText("Mascará de Sub rede Binaria: ");
					
					String binario = ipv4.binSubMask();
					labelSubBinario.setText(binario);
					
					String quantidade = ipv4.ipsDisponiveis();
					labelQuantidade.setText("Quantidade de Ips Total: " + "\n" + quantidade);
					
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );
				}
				
				
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textIp.setText("");
				labelClasse.setText(null);
				labelSubDecimal.setText(null);
				labeltextBinario.setText(null);
				labelSubBinario.setText(null);
				labelQuantidade.setText(null);
				textIp.requestFocus();
				
			}
		});
		tela.setVisible(true);
	}
}
