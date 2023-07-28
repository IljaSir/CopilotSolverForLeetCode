class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] a = parse(num1);
        int[] b = parse(num2);
        int real = a[0] * b[0] - a[1] * b[1];
        int imag = a[0] * b[1] + a[1] * b[0];
        return real + "+" + imag + "i";
    }
    
    int[] parse(String num) {
        int[] a = new int[2];
        int i = 0;
        while (num.charAt(i) != '+') {
            i++;
        }
        a[0] = Integer.parseInt(num.substring(0, i));
        a[1] = Integer.parseInt(num.substring(i + 1, num.length() - 1));
        return a;
    }
}