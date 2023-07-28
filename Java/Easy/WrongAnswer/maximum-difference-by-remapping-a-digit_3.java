class Solution {
    public int minMaxDifference(int num) {
        
        int max = 0;
        int min = 0;
        int[] digits = new int[10];
        int i = 0;
        while (num > 0) {
            digits[i++] = num % 10;
            num /= 10;
        }
        int[] digits2 = new int[i];
        int[] digits3 = new int[i];
        int[] digits4 = new int[i];
        for (int j = 0; j < i; j++) {
            digits2[j] = digits[j];
            digits3[j] = digits[j];
            digits4[j] = digits[j];
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] != 9) {
                digits2[j] = 9;
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] != 0) {
                digits3[j] = 0;
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] != 9) {
                digits4[j] = 9;
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] != 0) {
                digits4[j] = 0;
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            max = max * 10 + digits2[j];
        }
        for (int j = 0; j < i; j++) {
            min = min * 10 + digits3[j];
        }
        return max - min;
    }
}