class Solution {
    public int minMaxDifference(int num) {
        
        int[] digits = new int[10];
        int max = 0;
        int min = 0;
        int maxDigit = 0;
        int minDigit = 0;
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            digits[digit]++;
            maxDigit = Math.max(maxDigit, digit);
            minDigit = Math.min(minDigit, digit);
            n /= 10;
        }
        if (maxDigit == minDigit) {
            return 0;
        }
        int i = 0;
        while (digits[i] == 0) {
            i++;
        }
        if (i != minDigit) {
            min = num - digits[minDigit] * minDigit + digits[minDigit] * i;
        } else {
            i++;
            while (digits[i] == 0) {
                i++;
            }
            min = num - digits[minDigit] * minDigit + digits[minDigit] * i;
        }
        i = 9;
        while (digits[i] == 0) {
            i--;
        }
        if (i != maxDigit) {
            max = num - digits[maxDigit] * maxDigit + digits[maxDigit] * i;
        } else {
            i--;
            while (digits[i] == 0) {
                i--;
            }
            max = num - digits[maxDigit] * maxDigit + digits[maxDigit] * i;
        }
        return max - min;
    }
}