import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

class ColbaltConverter extends JFrame implements ActionListener {
    ColbaltConverter() {
        super("Colbalt Converter");
        buildGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void buildGUI() {
        cobaltInput = new JTextField(7);
        yearsInput = new JTextField(5);
        compute = new JButton("Compute");
        amountLeft = new JLabel("Amount Left: ");
        cobalt = new JLabel("Amount of Cobalt:");
        years = new JLabel ("Number of Years:");
        quit = new JButton("Quit");

        Container ct = getContentPane();
        ct.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 1; c.gridy = 1; c.gridwidth = 1; c.gridheight = 1;
        ct.add(yearsInput, c);

        c.gridx = 1; c.gridy = 0; c.gridwidth = 1; c.gridheight = 1;
        ct.add(cobaltInput, c);

        c.gridx = 0; c.gridy = 3; c.gridwidth = 1; c.gridheight = 1;
        ct.add(compute, c);

        c.gridx = 0; c.gridy = 5; c.gridwidth = 2; c.gridheight = 1;
        ct.add(amountLeft, c);

        c.gridx = 0; c.gridy = 1; c.gridwidth = 1; c.gridheight = 1;
        ct.add(years, c);

        c.gridx = 0; c.gridy = 0; c.gridwidth = 1; c.gridheight = 1;
        ct.add(cobalt, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 1; c.gridy = 3; c.gridwidth = 2; c.gridheight = 1;
        ct.add(quit, c);

        compute.addActionListener(this);
        quit.addActionListener(this);
    }

    private JTextField cobaltInput;
    private JTextField yearsInput;
    private JButton compute;
    private JLabel amountLeft;
    private JLabel cobalt;
    private JLabel years;
    private JButton quit;

 
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == compute){
           
            String Cobalt = cobaltInput.getText().toString();
            double cobalt = Double.parseDouble(Cobalt);

           String Years = yearsInput.getText().toString();
           int year = Integer.parseInt(Years);

            for (int n=1; n <= year; n++){
                cobalt = cobalt - (cobalt * 0.12);
            }
           
            DecimalFormat df = new DecimalFormat("#0.00");
            amountLeft.setText("Amount Left: " + df.format(cobalt));
        }
    

        else if(e.getSource() == quit) 
            System.exit(0);
    }
    

    public static void main(String[] args) {
        ColbaltConverter cc = new ColbaltConverter();
    }
}