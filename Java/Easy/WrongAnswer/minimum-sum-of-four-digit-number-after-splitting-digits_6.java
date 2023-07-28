class Solution {
    public int minimumSum(int num) {
        
        int sum = 0;
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);
        sum += digits[0] * 10 + digits[1];
        sum += digits[2] * 10 + digits[3];
        return sum;
    }
}