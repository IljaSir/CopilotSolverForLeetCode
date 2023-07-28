class Solution {
    public int countSpecialNumbers(int n) {
        
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (isSpecial(i)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isSpecial(int n) {
        if (n < 10) {
            return true;
        }
        int[] digits = new int[10];
        while (n > 0) {
            int digit = n % 10;
            if (digits[digit] == 1) {
                return false;
            }
            digits[digit] = 1;
            n /= 10;
        }
        return true;
    }
}