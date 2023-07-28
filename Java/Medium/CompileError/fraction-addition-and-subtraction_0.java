class Solution {
    public String fractionAddition(String expression) {
        
        int sign = 1;
        int numerator = 0;
        int denominator = 1;
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '+') {
                sign = 1;
                i++;
            }
            else if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            int j = i;
            while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            int[] fraction = getFraction(expression.substring(i, j));
            numerator = numerator * fraction[1] + sign * fraction[0] * denominator;
            denominator = denominator * fraction[1];
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            i = j;
        }
        return numerator + "/" + denominator;
    }
    private int[] getFraction(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) != '/') {
            i++;
        }
        int numerator = Integer.parseInt(s.substring(0, i));
        int denominator = Integer.parseInt(s.substring(i + 1));
        return new int[]{numerator, denominator};
    }
}