# 四则运算算式生成器+计算器

本程序能够自动随机生成各种运算

可以在加减乘除中选择运算，可以选择是否有括号，是否有小数，结论是否为正数等

生成的算式可以保存到本地中或打印出来

另外本程序附带计算器，可以进行一系列简单的运算

<img src="https://raw.githubusercontent.com/KobayashiSouryuu/FourOperationsGenerator/master/%E6%BC%94%E7%A4%BA1.png" width="50%">

<img src="https://raw.githubusercontent.com/KobayashiSouryuu/FourOperationsGenerator/master/%E6%BC%94%E7%A4%BA2.png" width="50%">

<img src="https://raw.githubusercontent.com/KobayashiSouryuu/FourOperationsGenerator/master/%E6%BC%94%E7%A4%BA3.png" width="50%">

<img src="https://raw.githubusercontent.com/KobayashiSouryuu/FourOperationsGenerator/master/%E6%BC%94%E7%A4%BA4.png" width="25%">

<img src="https://raw.githubusercontent.com/KobayashiSouryuu/FourOperationsGenerator/master/%E6%BC%94%E7%A4%BA5.png" width="50%">

## 已知bug

1.勾选小数时不会出现(-1,1)区间的小数

2.最大数输入为1且勾选小数时，会出现大于1的小数

3.Java的double精度问题导致在勾选除法或小数时部分计算结果有细小误差，假设应该是6，实际可能显示出的数字为6.0000000001

##### 如有其他bug欢迎反馈