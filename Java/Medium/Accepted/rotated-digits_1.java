class Solution {
    public int rotatedDigits(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isGood(int n) {
        boolean isGood = false;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isGood = true;
            }
            n /= 10;
        }
        return isGood;
    }
}