class Solution {
    public boolean isAdditiveNumber(String num) {
        
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
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
        Long num1 = Long.parseLong(num.substring(0, i));
        Long num2 = Long.parseLong(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start != num.length(); start += sum.length()) {
            num2 = num2 + num1;
            num1 = num2 - num1;
            sum = num2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}