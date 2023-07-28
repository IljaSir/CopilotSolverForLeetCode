class Solution {
    public int rotatedDigits(int n) {
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isValid(int n) {
        boolean valid = false;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit == 3 || lastDigit == 4 || lastDigit == 7) {
                return false;
            }
            if (lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9) {
                valid = true;
            }
            n /= 10;
        }
        return valid;
    }
}