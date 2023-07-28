class Solution {
    public int countSpecialNumbers(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                ans++;
            }
        }
        return ans;
    }
    
    private boolean isSpecial(int n) {
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