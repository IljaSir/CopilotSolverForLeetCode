class Solution {
    public String fractionAddition(String expression) {
        
        int a = 0, b = 1;
        int c, d;
        int sign = 1;
        int i = 0;
        if (expression.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        while (i < expression.length()) {
            int j = i;
            while (j < expression.length() && expression.charAt(j) >= '0' && expression.charAt(j) <= '9') {
                j++;
            }
            int num = Integer.parseInt(expression.substring(i, j));
            i = j;
            while (j < expression.length() && expression.charAt(j) != '/') {
                j++;
            }
            int den = Integer.parseInt(expression.substring(i + 1, j));
            i = j + 1;
            c = a * den + sign * num * b;
            d = b * den;
            int g = gcd(c, d);
            a = c / g;
            b = d / g;
            if (i < expression.length() && expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else {
                sign = 1;
            }
        }
        return a + "/" + b;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}