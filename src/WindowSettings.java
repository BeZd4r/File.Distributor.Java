import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WindowSettings  extends JFrame{

    WindowSettings(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("icon.png");
        this.setIconImage(image.getImage());

        this.setVisible(true);
        this.setResizable(true);
        this.setSize(400,600);
        this.getContentPane().setBackground(new Color(123,50,250));

        this.add(Labels("Distributor for your PC :)",100,0,200,100));
        this.add(Labels("Enter Folder`s path:",25,150,150,50));
    }
    public static JLabel Labels(String lbTxt, int x, int y , int width, int height){
        JLabel label = new JLabel();
        label.setText(lbTxt);
        label.setBounds(x,y,width,height);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
//    public static JLabel ChooseButton(){
//
//         JButton clearBut = new JButton("Choose Folder");
//         clearBut.setVisible(true);
//         clearBut.setBounds(95, 400,200,75);
//
//         ActionListener click = new ClearAction();
//         clearBut.addActionListener(click);
//
//
//         panel.setBounds(95, 400,200,75);
//         panel.add(clearBut);
//
//         return panel;
//    }
}
