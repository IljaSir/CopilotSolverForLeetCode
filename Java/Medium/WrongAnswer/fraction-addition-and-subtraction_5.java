class Solution {
    public String fractionAddition(String expression) {
        
        if (expression == null || expression.length() == 0) {
            return "";
        }
        int[] result = new int[]{0, 1};
        int sign = 1;
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            int[] fraction = getFraction(expression, i);
            result = add(result, fraction, sign);
            i += fraction[2];
        }
        return result[0] + "/" + result[1];
    }

    private int[] getFraction(String expression, int i) {
        int j = i;
        while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
            j++;
        }
        String fraction = expression.substring(i, j);
        String[] fractionArray = fraction.split("/");
        int numerator = Integer.valueOf(fractionArray[0]);
        int denominator = Integer.valueOf(fractionArray[1]);
        return new int[]{numerator, denominator, j - i};
    }

    private int[] add(int[] fraction1, int[] fraction2, int sign) {
        int numerator1 = fraction1[0];
        int denominator1 = fraction1[1];
        int numerator2 = fraction2[0] * sign;
        int denominator2 = fraction2[1];
        int numerator = numerator1 * denominator2 + numerator2 * denominator1;
        int denominator = denominator1 * denominator2;
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}