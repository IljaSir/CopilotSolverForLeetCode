class Solution {
    public String fractionAddition(String expression) {
        
        int numerator = 0;
        int denominator = 1;
        int start = 0;
        if (expression.charAt(0) != '-') {
            start = 1;
        }
        for (int i = start; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                String fraction = expression.substring(start, i);
                int[] fractionNums = getFraction(fraction);
                numerator = fractionNums[0] * denominator + fractionNums[1] * numerator;
                denominator = fractionNums[1] * denominator;
                start = i;
            }
        }
        String fraction = expression.substring(start);
        int[] fractionNums = getFraction(fraction);
        numerator = fractionNums[0] * denominator + fractionNums[1] * numerator;
        denominator = fractionNums[1] * denominator;
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }

    public int[] getFraction(String fraction) {
        int[] nums = new int[2];
        int index = fraction.indexOf('/');
        nums[0] = Integer.parseInt(fraction.substring(0, index));
        nums[1] = Integer.parseInt(fraction.substring(index + 1));
        return nums;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}