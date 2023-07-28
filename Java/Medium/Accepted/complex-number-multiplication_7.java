class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        String[] num1Parts = num1.split("\\+");
        String[] num2Parts = num2.split("\\+");
        int a = Integer.parseInt(num1Parts[0]);
        int b = Integer.parseInt(num1Parts[1].substring(0, num1Parts[1].length() - 1));
        int c = Integer.parseInt(num2Parts[0]);
        int d = Integer.parseInt(num2Parts[1].substring(0, num2Parts[1].length() - 1));
        int real = a * c - b * d;
        int imaginary = a * d + b * c;
        return real + "+" + imaginary + "i";
    }
}