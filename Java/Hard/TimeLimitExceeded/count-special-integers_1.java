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

    private boolean isSpecial(int x) {
        boolean[] digits = new boolean[10];
        while (x > 0) {
            int digit = x % 10;
            if (digits[digit]) {
                return false;
            }
            digits[digit] = true;
            x /= 10;
        }
        return true;
    }
}