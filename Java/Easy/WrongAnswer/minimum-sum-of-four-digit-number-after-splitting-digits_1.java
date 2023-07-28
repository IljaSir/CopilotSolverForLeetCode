class Solution {
    public int minimumSum(int num) {
        
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 16; i++) {
            int sum = 0;
            int a = 0;
            int b = 0;
            for (int j = 0; j < 4; j++) {
                if (((i >> j) & 1) == 1) {
                    a = a * 10 + digits[j];
                } else {
                    b = b * 10 + digits[j];
                }
            }
            sum = a + b;
            min = Math.min(min, sum);
        }
        return min;
    }
}