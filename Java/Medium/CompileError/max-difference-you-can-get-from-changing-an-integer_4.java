class Solution {
    public int maxDiff(int num) {
        
        int a = num, b = num;
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        int min = 10;
        int max = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < min) {
                min = digits[i];
            }
            if (digits[i] > max) {
                max = digits[i];
            }
        }
        int[] minDigits = new int[digits.length];
        int[] maxDigits = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == min) {
                minDigits[i] = 1;
            }
            if (digits[i] == max) {
                maxDigits[i] = 1;
            }
        }
        int minA = a, minB = b;
        for (int i = 0; i < minDigits.length; i++) {
            if (minDigits[i] == 1) {
                minA = minA - min * (int)Math.pow(10, minDigits.length - i - 1) + 1 * (int)Math.pow(10, minDigits.length - i - 1);
            }
        }
        for (int i = 0; i < minDigits.length; i++) {
            if (minDigits[i] == 1) {
                minB = minB - min * (int)Math.pow(10, minDigits.length - i - 1) + 9 * (int)Math.pow(10, minDigits.length - i - 1);
            }
        }
        int maxA = a, maxB = b;
        for (int i = 0; i < maxDigits.length; i++) {
            if (maxDigits[i] == 1) {
                maxA = maxA - max * (int)Math.pow(10, maxDigits.length - i - 1) + 9 * (int)Math.pow(10, maxDigits.length - i - 1);
            }
        }
        for (int i = 0; i < maxDigits.length; i++) {
            if (maxDigits[i
    }
}