class Solution {
    public boolean isAdditiveNumber(String num) {
        
        int len = num.length();
        for (int i = 1; i <= len / 2; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(i) == '0' && j - i > 1) {
            return false;
        }
        long num1 = Long.parseLong(num.substring(0, i));
        long num2 = Long.parseLong(num.substring(i, j));
        String sum = "";
        for (int k = j; k < num.length(); k += sum.length()) {
            num2 = num2 + num1;
            num1 = num2 - num1;
            sum = Long.toString(num2);
            if (!num.startsWith(sum, k)) {
                return false;
            }
        }
        return true;
    }
}