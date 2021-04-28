import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import javax.swing.*;

public class Count extends JFrame implements ActionListener
{
    JDialog dialog;
    JPanel countjp;
    JLabel shuru;
    JButton one, two, three, four, five, six, siven, eight, nine, zero, puls, subtract, multiply, divide;
    JButton leftbracket, rightbracket, point, makezero, zhengfu;
    JButton Ans = new JButton("=");
    JTextField Text = new JTextField(15);

    public static void main(String[] args)
    {
        Count c = new Count();
    }

    public Count()
    {
        dialog = new JDialog();
        countjp = new JPanel();
        shuru = new JLabel("欢迎使用计算器");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        siven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        puls = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("×");
        divide = new JButton("÷");
        leftbracket = new JButton("(");
        rightbracket = new JButton(")");
        point = new JButton(".");
        makezero = new JButton("C");
        zhengfu = new JButton("±");
        Ans = new JButton("=");
        Text = new JTextField(15);
        Text.setHorizontalAlignment(JTextField.RIGHT);

        Ans.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        one.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        two.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        three.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        four.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        five.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        six.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        siven.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        eight.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        nine.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        zero.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        puls.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        subtract.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        multiply.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        divide.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        leftbracket.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        rightbracket.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        point.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        makezero.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        zhengfu.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        Text.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        countjp.add(shuru);
        countjp.add(Text);

        countjp.add(leftbracket);
        countjp.add(rightbracket);
        countjp.add(makezero);
        countjp.add(divide);

        countjp.add(siven);
        countjp.add(eight);
        countjp.add(nine);
        countjp.add(multiply);

        countjp.add(four);
        countjp.add(five);
        countjp.add(six);
        countjp.add(subtract);

        countjp.add(one);
        countjp.add(two);
        countjp.add(three);
        countjp.add(puls);

        countjp.add(zhengfu);
        countjp.add(zero);
        countjp.add(point);
        countjp.add(Ans);

        dialog.setContentPane(countjp);
        dialog.setBounds(300, 200, 200, 250);
        dialog.setTitle("计算器");
        dialog.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==one)
        {
            Text.setText(Text.getText()+"1");
        }
        if(e.getSource()==two)
        {
            Text.setText(Text.getText()+"2");
        }
        if(e.getSource()==three)
        {
            Text.setText(Text.getText()+"3");
        }
        if(e.getSource()==four)
        {
            Text.setText(Text.getText()+"4");
        }
        if(e.getSource()==five)
        {
            Text.setText(Text.getText()+"5");
        }
        if(e.getSource()==six)
        {
            Text.setText(Text.getText()+"6");
        }
        if(e.getSource()==siven)
        {
            Text.setText(Text.getText()+"7");
        }
        if(e.getSource()==eight)
        {
            Text.setText(Text.getText()+"8");
        }
        if(e.getSource()==nine)
        {
            Text.setText(Text.getText()+"9");
        }
        if(e.getSource()==zero)
        {
            Text.setText(Text.getText()+"0");
        }
        if(e.getSource()==puls)
        {
            Text.setText(Text.getText()+"+");
        }
        if(e.getSource()==subtract)
        {
            Text.setText(Text.getText()+"-");
        }
        if(e.getSource()==multiply)
        {
            Text.setText(Text.getText()+"×");
        }
        if(e.getSource()==divide)
        {
            Text.setText(Text.getText()+"÷");
        }
        if(e.getSource()==point)
        {
            Text.setText(Text.getText()+".");
        }
        if(e.getSource()==leftbracket)
        {
            Text.setText(Text.getText()+"(");
        }
        if(e.getSource()==rightbracket)
        {
            Text.setText(Text.getText()+")");
        }
        if(e.getSource()==makezero)
        {
            Text.setText("");
        }
        if(e.getSource()==zhengfu)
        {
            Text.setText("-("+Text.getText()+")");
        }
        if (e.getSource() == Ans||e.getSource()==Text)
        {
            try
            {
                Text.setText(String.valueOf(CountAlgorithm.CountAlgorithm(Text.getText() + "=")));
            }
            catch (EmptyStackException ee)
            {
                Text.setText("输入错误！");
            }
        }
    }
}
