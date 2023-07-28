class Solution {
    public boolean isAdditiveNumber(String num) {
        
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        long num1 = 0, num2 = 0;
        for (int k = 0; k < i; k++) {
            num1 = num1 * 10 + num.charAt(k) - '0';
        }
        for (int k = i; k < i + j; k++) {
            num2 = num2 * 10 + num.charAt(k) - '0';
        }
        String sum;
        for (int start = i + j; start != num.length(); start += sum.length()) {
            num2 = num2 + num1;
            num1 = num2 - num1;
            sum = Long.toString(num2);
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}