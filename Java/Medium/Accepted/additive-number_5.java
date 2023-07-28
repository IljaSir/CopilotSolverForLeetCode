class Solution {
    public boolean isAdditiveNumber(String num) {
        
        for (int i = 1; i <= num.length() / 2; ++i) {
            for (int j = 1; Math.max(j, i) <= num.length() - i - j; ++j) {
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
        String sum;
        Long x1 = Long.valueOf(num.substring(0, i));
        Long x2 = Long.valueOf(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}