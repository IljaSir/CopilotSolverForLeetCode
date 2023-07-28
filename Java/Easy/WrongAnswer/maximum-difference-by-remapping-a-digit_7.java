class Solution {
    public int minMaxDifference(int num) {
        
        int max = num;
        int min = num;
        int[] maxDigits = new int[10];
        int[] minDigits = new int[10];
        int[] digits = new int[10];
        int i = 0;
        while (num > 0) {
            int d = num % 10;
            digits[i] = d;
            maxDigits[i] = d;
            minDigits[i] = d;
            num /= 10;
            i++;
        }
        int size = i;
        int maxDigit = 0;
        int minDigit = 9;
        for (i = 0; i < size; i++) {
            int d = digits[i];
            if (d > maxDigit) {
                maxDigit = d;
            }
            if (d < minDigit) {
                minDigit = d;
            }
        }
        int maxDiff = 0;
        int minDiff = 0;
        for (i = 0; i < size; i++) {
            if (digits[i] == maxDigit) {
                maxDigits[i] = minDigit;
            }
            if (digits[i] == minDigit) {
                minDigits[i] = maxDigit;
            }
            maxDiff = maxDiff * 10 + maxDigits[i];
            minDiff = minDiff * 10 + minDigits[i];
        }
        return maxDiff - minDiff;
    }
}