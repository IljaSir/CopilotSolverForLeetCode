class Solution {
    public int minimumSum(int num) {
        
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);
        int min1 = 0, min2 = 0;
        for (int i = 0; i < 4; i++) {
            min1 = min1 * 10 + digits[i];
            min2 = min2 * 10 + digits[3 - i];
        }
        return min1 + min2;
    }
}