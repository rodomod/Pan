import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Pan  {
		 JPanel panel=new JPanel();
	     JFrame fr=new JFrame("'21'");
	     JTextField display=new JTextField(); 
	     JButton num[]=new JButton[10];
		 JButton back,pow,ops,pnt,sum,sub,sqrt,mul,div,eqals; 
		 Font  font=new Font("Tahoma",Font.PLAIN,13);
   Pan()  {
		 panel.setLayout(null);
		 panel.setFocusable(true);
		 panel.grabFocus();
display.setBounds(5, 10, 240, 50);
display.setFont(new Font("Tahoma",Font.PLAIN,21));
display.setHorizontalAlignment(SwingConstants.RIGHT);
display.setEditable(false);
panel.add(display);
		 
num[0]=new JButton("0");
num[0].setBounds(70, 250, 50, 50);
num[0].setFont(font);
panel.add(num[0]);
		  for(int x=0;x<3;x++) {
		     for(int y=0;y<3;y++) {
num[x*3+y+1]=new JButton((x*3+y+1)+"");
num[x*3+y+1].setBounds(x*(50+10)+10, y*(50+10)+70, 50, 50);
num[x*3+y+1].setFont(font);
panel.add(num[x*3+y+1]);
	 }
}
		
back=new JButton("C");
back.setBounds(10, 250, 50, 50);
back.setFont(font);
panel.add(back);
		            
pow=new JButton("^3");
pow.setBounds(10, 310, 50, 50);
pow.setFont(font);
panel.add(pow);
		  	      
ops=new JButton("-/+");
ops.setBounds(130, 250, 50, 50);
ops.setFont(new Font("Tahoma",Font.PLAIN,9));
panel.add(ops);
		    	    
pnt=new JButton(".");
pnt.setBounds(70, 310, 50, 50);
pnt.setFont(new Font("Tahoma",Font.PLAIN,13));
panel.add(pnt);
		    	    
sum=new JButton("+");
sum.setBounds(190, 70, 50, 50);
sum.setFont(font);
panel.add(sum);
		    	    
sub=new JButton("-");
sub.setBounds(190, 130, 50, 50);
sub.setFont(font);
panel.add(sub);
		    	    
sqrt=new JButton("sqrt");
sqrt.setBounds(130, 310, 50, 50);
sqrt.setFont(new Font("Tahoma",Font.PLAIN,9));
panel.add(sqrt);
		    	    
mul=new JButton("*");
mul.setBounds(190, 190, 50, 50);
mul.setFont(font);
panel.add(mul);
		
div=new JButton("/");
div.setBounds(190, 250, 50, 50);
div.setFont(font);
panel.add(div);
		    	    
eqals=new JButton("=");
eqals.setBounds(190, 310, 50, 50);
eqals.setFont(font);
panel.add(eqals);

fr.setContentPane(panel);
fr.pack();
fr.setSize(257,397);
fr.setLocationRelativeTo(null);
fr.setResizable(false);
fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fr.setVisible(true);

ActionListener as=(ActionEvent e)-> {
    JButton um=(JButton)e.getSource();
    display.setText(display.getText()+um.getText());
       };
for(JButton um : num) {um.addActionListener(as);}
Han an=new Han(this);
pow.addActionListener(an);
sqrt.addActionListener(an);
back.addActionListener(an);
ops.addActionListener(an);
sum.addActionListener(an);
sub.addActionListener(an);
mul.addActionListener(an);
div.addActionListener(an);
pnt.addActionListener(an); 
eqals.addActionListener(an);
             }
public class Han implements ActionListener {
    Pan mod;
    char car=' ';  
    double drezult=0;
Han(Pan mod){this.mod=mod;}
    @Override
public void actionPerformed(ActionEvent e) {
        JButton clickedbtn=(JButton)e.getSource();
        String dtext=mod.display.getText();
        double dcurent=0; 
        if(!"".equals(dtext)){dcurent=Double.parseDouble(dtext);}
        Object obj=e.getSource();
             if(obj==mod.sum){car='+';drezult=dcurent;mod.display.setText("");}
        else if(obj==mod.sub){car='-';drezult=dcurent;mod.display.setText("");}
        else if(obj==mod.mul){car='*';drezult=dcurent;mod.display.setText("");}
        else if(obj==mod.div){car='/';drezult=dcurent;mod.display.setText("");}
else if(obj==mod.eqals){
            if(car=='+'){drezult+=dcurent;mod.display.setText(""+drezult);}
            if(car=='-'){drezult-=dcurent;mod.display.setText(""+drezult);}
            if(car=='*'){drezult*=dcurent;mod.display.setText(""+drezult);}
            if(car=='/'){drezult/=dcurent;mod.display.setText(""+drezult);}
                   }
else  if(obj==mod.pnt){
      String pnt=mod.display.getText();
      if(!pnt.contains("."))mod.display.setText(mod.display.getText()+".");
                      }
else if(obj==mod.ops){
      double ops=Double.parseDouble(String.valueOf(mod.display.getText()));
      ops*=(-1.D);
      mod.display.setText(String.valueOf(ops));
                      }
else if(obj==mod.back){
	   String tmp;
       tmp =mod.display.getText();
mod.display.setText(tmp.substring(0, tmp.length() - 1));
                      }
else if(obj==mod.sqrt){
      double fm=Double.parseDouble(mod.display.getText());
      double sm=Double.parseDouble(mod.display.getText());
      String sqrt=mod.display.getText();
      if(sqrt.indexOf("")==0)mod.display.setText(Math.sqrt(sm*fm/sm)+"");
                      }
else if(obj==mod.pow){
      double fs=Double.parseDouble(mod.display.getText());
      String pow=mod.display.getText();
      if(pow.indexOf("")==0){mod.display.setText(Math.pow(fs,3)+"");}
                      }
else {String  clickedbtnLabel=clickedbtn.getText();
          mod.display.setText(dtext+clickedbtnLabel);}
     }
    }
public static void main(String[] args) {
	 SwingUtilities.invokeLater(() -> { 
             JFrame.setDefaultLookAndFeelDecorated(true);
          new Pan();
});
	}
 }