import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BMIcalculator extends JFrame {

    private JPanel jpan;
    private JPanel lbltxts;
    private JPanel lblinputs;
    private JLabel lblweight;
    private JTextField txtweight;
    private JTextField txtheight;
    private JLabel lblheight;
    private JPanel jpantopic;
    private JLabel lbltopic;
    private JComboBox cmbox1;
    private JButton btnsubmit;
    private JButton btnclear;
    private JLabel lblVname;
    private JPanel body;


    public BMIcalculator(){
        add(jpan);
        setVisible(true);
        setSize(400,400);
        setTitle("BMI Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float height = Float.parseFloat(txtheight.getText());
                float weight = Float.parseFloat(txtweight.getText());
                float BMI = 0;

                if(cmbox1.getSelectedItem() == "Kg/m"){
                    BMI = weight / (height * height);
                }
                else if(cmbox1.getSelectedItem() == "Pounds/inch"){
                    BMI = (weight * 703) / (height * height);
                }
                float x = BMI;
                if(BMI >= 30){
                    lblVname.setText("Obese");
                } else if (BMI > 25) {
                    lblVname.setText("Overweight");
                }else if(BMI > 18.5){
                    lblVname.setText("Normal");
                }else{
                    lblVname.setText("Underweight");
                }
            }
        });
        btnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtweight.setText("");
                txtheight.setText("");
                lblVname.setText("");
            }
        });


        cmbox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbox1.getSelectedItem() == "Kg/m"){
                    lblweight.setText("Enter Your Weight (Kg) : ");
                    lblheight.setText("Enter Your Height (m) : ");
                }
                else {
                    lblweight.setText("Enter Your Weight (Pounds) : ");
                    lblheight.setText("Enter Your Height (inch) : ");
                }
            }
        });
    }

    public static void main(String[] args) {
        BMIcalculator bmi = new BMIcalculator();
    }
}
