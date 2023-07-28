class Solution {
    public int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSpecial(int n) {
        boolean[] digits = new boolean[10];
        while (n > 0) {
            int digit = n % 10;
            if (digits[digit]) {
                return false;
            }
            digits[digit] = true;
            n /= 10;
        }
        return true;
    }
}