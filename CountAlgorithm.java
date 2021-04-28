import java.util.Stack;

public class CountAlgorithm
{
    public static void main(String[] args)
    {
        CountAlgorithm c = new CountAlgorithm();
    }

    public static double CountAlgorithm(String p)
    {
        double sum = 0;
        Stack snum = new Stack();
        Stack ssign = new Stack();
        int stacknum = 0;
        int kuohaostacknum = 0;
        boolean khflag = false;
        String str = new String();
        for (int i = 0; i < p.length(); i++)
        {
            if (Character.isDigit(p.charAt(i)) || p.charAt(i) == '.')
            {
                str = str + p.charAt(i);
            }
            else
            {
                if (!str.isEmpty())
                {
                    snum.push(str);
                    stacknum++;
                    if (khflag == true)
                    {
                        kuohaostacknum++;
                    }
                }
                str = "";
                while (true)
                {
                    if (ssign.empty() ||
                            ((p.charAt(i) == '×' || p.charAt(i) == '÷' || p.charAt(i) == '*' || p.charAt(i) == '/') &&
                                    (ssign.peek().toString().charAt(0) == '+' || ssign.peek().toString().charAt(0) == '-')) ||
                            p.charAt(i) == '(' || ssign.peek().toString().charAt(0) == '('
                    )
                    {
                        if (p.charAt(i) == '(')
                        {
                            khflag = true;
                        }
                        ssign.push(p.charAt(i));
                        break;
                    }
                    if (stacknum < 2)
                    {
                        break;
                    }
                    if (kuohaostacknum < 2 && khflag == true)
                    {
                        break;
                    }
                    double a = Double.parseDouble(snum.peek().toString());
                    snum.pop();
                    stacknum--;
                    if (khflag == true)
                    {
                        kuohaostacknum--;
                    }
                    double b = Double.parseDouble(snum.peek().toString());
                    snum.pop();
                    stacknum--;
                    if (khflag == true)
                    {
                        kuohaostacknum--;
                    }
                    if (ssign.peek().toString().charAt(0) == '+')
                    {
                        snum.push(String.valueOf(a + b));
                        stacknum++;
                        if (khflag == true)
                        {
                            kuohaostacknum++;
                        }
                        ssign.pop();
                    }
                    else if (ssign.peek().toString().charAt(0) == '-')
                    {
                        snum.push(String.valueOf(b - a));
                        stacknum++;
                        if (khflag == true)
                        {
                            kuohaostacknum++;
                        }
                        ssign.pop();
                    }
                    else if (ssign.peek().toString().charAt(0) == '×' || ssign.peek().toString().charAt(0) == '*')
                    {
                        snum.push(String.valueOf(a * b));
                        stacknum++;
                        if (khflag == true)
                        {
                            kuohaostacknum++;
                        }
                        ssign.pop();
                    }
                    else
                    {
                        snum.push(String.valueOf(b / a));
                        stacknum++;
                        if (khflag == true)
                        {
                            kuohaostacknum++;
                        }
                        ssign.pop();
                    }
                    if (p.charAt(i) == ')' && ssign.peek().toString().charAt(0) == '(')
                    {
                        kuohaostacknum = 0;
                        khflag = false;
                        ssign.pop();
                        i++;
                    }
                }
            }
        }
        sum = Double.parseDouble(snum.peek().toString());
        String c = "";
        while (!ssign.empty())
        {
            c = ssign.peek().toString();
            ssign.pop();
        }
        if (c.equals("-"))
        {
            sum = -sum;
        }
        return sum;
    }
}
