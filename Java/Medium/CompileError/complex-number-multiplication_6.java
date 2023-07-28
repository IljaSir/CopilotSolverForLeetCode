class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] n1 = getNum(num1);
        int[] n2 = getNum(num2);
        int real = n1[0] * n2[0] - n1[1] * n2[1];
        int imaginary = n1[0] * n2[1] + n1[1] * n2[0];
        return real + "+" + imaginary + "i";
    }
}