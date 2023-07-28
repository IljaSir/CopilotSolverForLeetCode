class Solution {
    public int minMaxDifference(int num) {
        
        int[] digits = new int[10];
        int max = 0;
        int min = 0;
        int n = num;
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }
        int i = 0;
        while (digits[i] == 0) {
            i++;
        }
        int j = 9;
        while (digits[j] == 0) {
            j--;
        }
        int maxDigit = j;
        int minDigit = i;
        if (maxDigit == minDigit) {
            return 0;
        }
        int k = 0;
        while (k < 10) {
            if (k == maxDigit) {
                max = max * 10 + minDigit;
            } else if (k == minDigit) {
                min = min * 10 + maxDigit;
            } else {
                max = max * 10 + k;
                min = min * 10 + k;
            }
            k++;
        }
        return max - min;
    }
}