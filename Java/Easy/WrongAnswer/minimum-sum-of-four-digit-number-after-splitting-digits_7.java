class Solution {
    public int minimumSum(int num) {
        
        int[] digits = new int[4];
        int i = 3;
        while (num > 0) {
            digits[i--] = num % 10;
            num /= 10;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < 4; j++) {
            sum1 = sum1 * 10 + digits[j];
            sum2 = sum1;
            for (int k = j + 1; k < 4; k++) {
                sum2 = sum2 * 10 + digits[k];
            }
            if (sum2 > 0) {
                break;
            }
        }
        return sum1 + sum2;
    }
}