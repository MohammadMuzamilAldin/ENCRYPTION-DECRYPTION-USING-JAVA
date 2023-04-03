import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class EncryptDecrypt2{
	char []name1;
	char []key1;
	int len;
	char []newe;
	char []newe1;
	EncryptDecrypt2(String key,String name)
	{

		
		
		key1= new char[key.length()];
		for(int i=0;i<key.length();i++)
		{
			key1[i]=key.charAt(i);
		}
		name1=new char[name.length()];
		for(int i=0;i<name.length();i++)
		{
			name1[i]=name.charAt(i);
		}
		len=name.length();
		newe=new char[len];
		newe1=new char[len];
		
	}

	public String encrypt()
	{
		for(int i=0;i<len;i++)
		{
			newe[i]=(char) (name1[i]+key1[i]);
		}
		return String.valueOf(newe);
		
	}
	public String decrypt()
	{
		for(int i=0;i<len;i++)
		{
			newe1[i]=(char) (newe[i]-key1[i]);
		}
		return String.valueOf(newe1);
	}
}
class simple extends JFrame{
	JLabel jl,jl1,jl2,jl3,jl4;
simple(){
	setSize(500, 500);
	
	
	jl2=new JLabel("Encryption & Decryption");
	jl2.setBounds(50,0,500,50);
	jl2.setFont(new Font("Arial",Font.BOLD,30));
	add(jl2);
	jl=new JLabel("Enter Key value:");
	jl.setBounds(50,100,100,25);
	add(jl);
	jl1=new JLabel("Enter data:");
	jl1.setBounds(200,100,100,25);
	add(jl1);
	jl3=new JLabel("Result:");
	jl3.setFont(new Font("Arial",Font.BOLD,20));
	jl3.setBounds(100,400,100,25);
	add(jl3);
	
	JTextField jt,jt1;
	jt=new JTextField(20);
	jt.setBounds(50,200,100,25);
	jt1=new JTextField(20);
	jt1.setBounds(200,200,100,25);
	jl4=new JLabel();
	jl4.setBounds(250,400,100,25);
	add(jt);
	add(jt1);
	add(jl4);
	
	JButton jb,jb1;
	jb=new JButton("Encrypt");
	jb.setBounds(50, 300, 100, 25);
	jb1=new JButton("Decrypt");
	jb1.setBounds(200, 300, 100, 25);
	add(jb);
	add(jb1);
	jb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String key=jt.getText();
			String name=jt1.getText();
			EncryptDecrypt2 e=new EncryptDecrypt2(key,name);
			String en1=e.encrypt();
			jl4.setText(en1);
			jl4.setFont(new Font("Arial",Font.PLAIN,20));
			try {
				JOptionPane.showMessageDialog(null,"Success Encrypted");
    }
 catch(Exception ae1){
            JOptionPane.showMessageDialog(null,"Error");
    }
		}
	});
	jb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String key=jt.getText();
			String name=jt1.getText();
			EncryptDecrypt2 e=new EncryptDecrypt2(key,name);
			String en1=e.encrypt();
			
			String de=e.decrypt();
			jl4.setText(de);
			jl4.setFont(new Font("Arial",Font.PLAIN,20));
			try {
				JOptionPane.showMessageDialog(null,"Success Decrypted");
    }
 catch(Exception ae1){
            JOptionPane.showMessageDialog(null,"Error");
    }
		}
	});
	
	setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}

class xor extends JFrame{
	JLabel jl,jl1,jl2,jl3,jl4;
	JTextField jt,jt1;
	char []key;
	char []value;
	int []keyascii;
	int []valueascii;
	int []encrpdata;
	int []decrpdata;
	char []decval;
	char []encval;
	int len;
	xor(){
	
	jl2=new JLabel("Encryption & Decryption");
	jl2.setBounds(50,0,500,50);
	jl2.setFont(new Font("Arial",Font.BOLD,30));
	add(jl2);
	jl=new JLabel("Enter Key value");
	jl.setBounds(50,100,100,25);
	add(jl);
	jl1=new JLabel("Enter data");
	jl1.setBounds(200,100,100,25);
	add(jl1);
	jl3=new JLabel("Result");
	jl3.setBounds(100,400,100,25);
	add(jl3);
	jl3.setFont(new Font("Arial",Font.BOLD,20));
	
	jt=new JTextField(20);
	jt.setBounds(50,200,100,25);
	jt1=new JTextField(20);
	jt1.setBounds(200,200,100,25);
	jl4=new JLabel();
	jl4.setBounds(250,400,100,25);
	add(jt);
	add(jt1);
	add(jl4);
	
	JButton jb,jb1;
	jb=new JButton("Encrypt");
	jb.setBounds(50, 300, 100, 25);
	add(jb);
	jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			len=jt1.getText().length();
			key=jt.getText().toCharArray();
			value=jt1.getText().toCharArray();
			encrpdata=new int[len];
			valueascii=new int[len];
			keyascii=new int[len];
			encval=new char[len];
		
			for(int i=0;i<len;i++) {
				valueascii[i]=value[i];
				keyascii[i]=key[i];
				encrpdata[i]=(keyascii[i]^valueascii[i]);
				//System.out.print(valueascii[i]);
				encval[i]=(char)encrpdata[i];
			}

			jl4.setText(String.valueOf(encval));
			jl4.setFont(new Font("Arial",Font.PLAIN,20));
			try {
				JOptionPane.showMessageDialog(null,"Success Encrypted");
    }
 catch(Exception ae){
            JOptionPane.showMessageDialog(null,"Error");
    }
		}
	});
	jb1=new JButton("Decrypt");
	jb1.setBounds(200, 300, 100, 25);
	
	add(jb1);
	jb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			decrpdata=new int[len];
			decval=new char[len];
for(int i=0;i<len;i++) {
	//System.out.print(encval[i]);
	
	//System.out.print(keyascii[i]);
	decrpdata[i]=(encrpdata[i]^keyascii[i]);
	//System.out.print(decrpdata[i]);
	decval[i]=(char) decrpdata[i];
}

jl4.setText(String.valueOf(decval));
jl4.setFont(new Font("Arial",Font.PLAIN,20));
try {
	JOptionPane.showMessageDialog(null,"Success decrypted");
}
catch(Exception ae){
JOptionPane.showMessageDialog(null,"Error");
}
		}
	});
	setSize(500, 500);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
}

class main extends JFrame{
	JLabel jl1;
	JRadioButton jr1,jr2;
	main(){
		jl1=new JLabel("ENCRYPTION AND DECRYPTION");
		add(jl1);
		jl1.setBounds(150,0,250,100);
		jr1=new JRadioButton("SIMPLE CIPHER TEXT");
		jr1.setBounds(50, 120, 250, 50);
		add(jr1);
		jr1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new simple();
				try {
					JOptionPane.showMessageDialog(null,"Success");
	    }
	 catch(Exception ae){
	            JOptionPane.showMessageDialog(null,"Error");
	    }
			}
			
		});
		jr2=new JRadioButton("XOR CIPHER TEXT");
		jr2.setBounds(300, 120, 250, 50);
		add(jr2);
		jr2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new xor();
			}
		});
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new main();
	}

}
