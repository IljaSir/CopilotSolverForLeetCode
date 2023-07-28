class Solution {
    public int maxDiff(int num) {
        
        int a = 0, b = 0;
        int x = 0, y = 0;
        int i = 0;
        int[] digits = new int[8];
        while (num > 0) {
            digits[i++] = num % 10;
            num /= 10;
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] < 9) {
                x = digits[j];
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            if (digits[j] > 1) {
                y = digits[j];
                break;
            }
        }
        for (int j = i - 1; j >= 0; j--) {
            if (digits[j] == x) {
                digits[j] = 9;
            }
            a = a * 10 + digits[j];
        }
        for (int j = i - 1; j >= 0; j--) {
            if (digits[j] == y) {
                digits[j] = 1;
            }
            b = b * 10 + digits[j];
        }
        return a - b;
    }
}