import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{

    // 定义组件
    JPanel JP;
    JCheckBox puls, subtract, multiply, divide, bracket, SmallNum, AnsFlag, OnlyPositive;//加减乘除复选框
    JTextArea outcome;//结果多行文本框
    JTextField MaxNum;//算式最大数字
    JTextField QuestionNum;//算式数量
    JLabel ChooseSign;
    JLabel ChooseFun;
    JLabel TextMaxNum;
    JLabel TextQuestionNum;
    JButton Test;
    JButton Print;
    JScrollPane JSP;
    JButton Counter;
    JButton Printer;

    public static void main(String[] args)
    {
        Main TEST = new Main();
    }

    // 构造函数
    public Main()
    {

        JP = new JPanel();
        puls = new JCheckBox("加号+");
        subtract = new JCheckBox("减号-");
        multiply = new JCheckBox("乘号×");
        divide = new JCheckBox("除号÷");
        bracket = new JCheckBox("括号()");
        SmallNum = new JCheckBox("小数计算");
        AnsFlag = new JCheckBox("显示答案");
        OnlyPositive = new JCheckBox("得数为正");
        outcome = new JTextArea("————————欢迎使用本程序————————\n" +
                "勾选所需功能并输入最大数与数量点击生成就可以生成算式啦！\n" +
                "选中所需算式或按Ctrl+A全选后可以按Ctrl+C复制\n" +
                "也可以点击本地保存按钮本地保存为txt文件\n", 21, 40);
        outcome.setEditable(false);
        MaxNum = new JTextField("100", 5);
        QuestionNum = new JTextField("20", 5);
        ChooseSign = new JLabel("请选择你需要的符号");
        ChooseFun = new JLabel("请选择需要的功能");
        TextMaxNum = new JLabel("请输入题目最大数");
        TextQuestionNum = new JLabel("题目数量");
        JSP = new JScrollPane(outcome);
        JSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        Test = new JButton("生成算式");
        Test.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        Print = new JButton("保存本地");
        Print.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        Counter = new JButton("计算器");
        Counter.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));
        Printer = new JButton("打印");
        Printer.addActionListener(this);
        this.setLayout(new GridLayout(1, 0));

        JP.add(ChooseSign);
        JP.add(puls);
        JP.add(subtract);
        JP.add(multiply);
        JP.add(divide);
        JP.add(bracket);
        JP.add(ChooseFun);
        JP.add(SmallNum);
        JP.add(AnsFlag);
        JP.add(OnlyPositive);
        JP.add(Counter);
        JP.add(Printer);
        JP.add(TextMaxNum);
        JP.add(MaxNum);
        JP.add(TextQuestionNum);
        JP.add(QuestionNum);
        JP.add(Test);
        JP.add(Print);

        JP.add(JSP);

        // 加入到JFrame
        this.add(JP);
        this.setSize(500, 500);
        this.setTitle("四则算式生成器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Test)
        {
            if (puls.isSelected() == false && subtract.isSelected() == false && multiply.isSelected() == false && divide.isSelected() == false)
            {
                outcome.setText("");
                outcome.append("错误，请选择运算符号！\n");
                return;
            }
            try
            {
                int GetMaxNum = Integer.parseInt(MaxNum.getText()) + 1;
                int GetQuestionNum = Integer.parseInt(QuestionNum.getText());
                if (GetMaxNum <= 1 || GetQuestionNum <= 0)
                {
                    outcome.setText("");
                    outcome.append("错误，请输入正整数！\n");
                    return;
                }
            }
            catch (NumberFormatException eNum)
            {
                outcome.setText("");
                outcome.append("错误，请输入正确的数字！\n");
                return;
            }
            int GetMaxNum = Integer.parseInt(MaxNum.getText());
            int GetQuestionNum = Integer.parseInt(QuestionNum.getText());
            outcome.setText("");
            for (int i = 0; i < GetQuestionNum; i++)
            {
                String Equation = new String();
                Random rand = new Random();
                {
                    boolean kuohaoflag = false;
                    boolean youfuhao = false;
                    int NumSum = rand.nextInt(4) + 2;
                    for (int j = 0; j < NumSum; j++)
                    {
                        int num = rand.nextInt(GetMaxNum) + 1;
                        Equation = Equation + String.valueOf(num);
                        if (SmallNum.isSelected() == true)
                        {
                            int small = rand.nextInt(3);
                            if (small == 1)
                            {
                                Equation = Equation + "." + String.valueOf(rand.nextInt(9) + 1);
                            }
                            else if (small == 2)
                            {
                                Equation = Equation + "." + String.valueOf(rand.nextInt(99) + 1);
                            }
                        }
                        if (kuohaoflag == true && youfuhao == true && bracket.isSelected() == true)
                        {
                            int kuohao = rand.nextInt(2);
                            if (kuohao == 0)
                            {
                                Equation = Equation + ")";
                                kuohaoflag = false;
                                youfuhao = false;
                            }
                        }
                        while (true)
                        {
                            int SignNum = rand.nextInt(4);
                            if (SignNum == 0 && puls.isSelected() == true)
                            {
                                if (kuohaoflag == true)
                                {
                                    youfuhao = true;
                                }
                                Equation = Equation + "+";
                                int kuohao = rand.nextInt(2);
                                if (kuohao == 0 && kuohaoflag == false && j + 1 != NumSum && bracket.isSelected() == true)
                                {
                                    Equation = Equation + "(";
                                    kuohaoflag = true;
                                }
                                break;
                            }
                            else if (SignNum == 1 && subtract.isSelected() == true)
                            {
                                if (kuohaoflag == true)
                                {
                                    youfuhao = true;
                                }
                                Equation = Equation + "-";
                                int kuohao = rand.nextInt(2);
                                if (kuohao == 0 && kuohaoflag == false && j + 1 != NumSum && bracket.isSelected() == true)
                                {
                                    Equation = Equation + "(";
                                    kuohaoflag = true;
                                }
                                break;
                            }
                            else if (SignNum == 2 && multiply.isSelected() == true)
                            {
                                if (kuohaoflag == true)
                                {
                                    youfuhao = true;
                                }
                                Equation = Equation + "×";
                                int kuohao = rand.nextInt(2);
                                if (kuohao == 0 && kuohaoflag == false && j + 1 != NumSum && bracket.isSelected() == true)
                                {
                                    Equation = Equation + "(";
                                    kuohaoflag = true;
                                }
                                break;
                            }
                            else if (SignNum == 3 && divide.isSelected() == true)
                            {
                                if (kuohaoflag == true)
                                {
                                    youfuhao = true;
                                }
                                Equation = Equation + "÷";
                                int kuohao = rand.nextInt(2);
                                if (kuohao == 0 && kuohaoflag == false && j + 1 != NumSum && bracket.isSelected() == true)
                                {
                                    Equation = Equation + "(";
                                    kuohaoflag = true;
                                }
                                break;
                            }
                        }
                    }
                    int num = rand.nextInt(GetMaxNum) + 1;
                    Equation = Equation + String.valueOf(num);
                    if (SmallNum.isSelected() == true)
                    {
                        int small = rand.nextInt(3);
                        if (small == 1)
                        {
                            Equation = Equation + "." + String.valueOf(rand.nextInt(9) + 1);
                        }
                        else if (small == 2)
                        {
                            Equation = Equation + "." + String.valueOf(rand.nextInt(99) + 1);
                        }
                    }
                    if (kuohaoflag == true && bracket.isSelected() == true)
                    {
                        Equation = Equation + ")";
                    }
                }
                Equation = Equation + "=";
                if (CountAlgorithm.CountAlgorithm(Equation) <= GetMaxNum && -CountAlgorithm.CountAlgorithm(Equation) <= GetMaxNum)
                {
                    if (OnlyPositive.isSelected())
                    {
                        if (CountAlgorithm.CountAlgorithm(Equation) < 0)
                        {
                            i--;
                            continue;
                        }
                    }
                    outcome.append(Equation);
                    if (AnsFlag.isSelected())
                    {
                        if (SmallNum.isSelected() == false && divide.isSelected() == false)
                        {
                            int k;
                            k = (int) (CountAlgorithm.CountAlgorithm(Equation));
                            outcome.append(String.valueOf(k));
                        }
                        else
                        {
                            outcome.append(String.valueOf(CountAlgorithm.CountAlgorithm(Equation)));
                        }
                    }
                    outcome.append("\n");
                }
                else
                {
                    i--;
                }
            }

        }
        if (e.getSource() == Print)
        {
            JFileChooser SaveAs = new JFileChooser();
            SaveAs.setApproveButtonText("保存");
            SaveAs.showOpenDialog(this);
            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
            try
            {
                if (fileName == null)
                {
                    return;
                }
                BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
                outFile.write(outcome.getText());
                outFile.close();
            }
            catch (IOException ex)
            {
            }
        }
        if (e.getSource() == Counter)
        {
            Count c = new Count();
        }
        if (e.getSource() == Printer)
        {
            //先保存
            JFileChooser SaveAs = new JFileChooser();
            File fileName = new File("E:\\print_temporary.txt");
            System.out.println("hahaha");
            try
            {
                if (fileName == null)
                {
                    return;
                }
                BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
                outFile.write(outcome.getText());
                outFile.close();
            }
            catch (IOException ex)
            {
            }
            //打印
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();//构建打印请求属性集
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;//设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);//查找所有的可用打印服务
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();//定位默认的打印服务
            // 显示打印对话框
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
            if (service != null)
            {
                try
                {
                    DocPrintJob job = service.createPrintJob(); // 创建打印作业
                    FileInputStream fis; // 构造待打印的文件流
                    fis = new FileInputStream(fileName);
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }
            }
            if (fileName.exists() && fileName.isFile())
            {
                fileName.delete();
            }
        }
    }
}