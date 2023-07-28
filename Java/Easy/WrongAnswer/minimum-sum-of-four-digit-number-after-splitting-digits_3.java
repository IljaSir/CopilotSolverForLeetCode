class Solution {
    public int minimumSum(int num) {
        
        int[] digits = new int[4];
        int i = 0;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i++;
        }
        Arrays.sort(digits);
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < 4; j++) {
            sum1 = sum1 * 10 + digits[j];
            if (j < 3) {
                sum2 = sum2 * 10 + digits[j];
            }
        }
        return sum1 + sum2;
    }
}