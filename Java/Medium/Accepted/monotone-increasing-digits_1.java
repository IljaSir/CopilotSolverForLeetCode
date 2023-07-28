class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        char[] digits = String.valueOf(n).toCharArray();
        int i = 1;
        while (i < digits.length && digits[i - 1] <= digits[i]) {
            i++;
        }
        if (i < digits.length) {
            while (i > 0 && digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                i--;
            }
            for (i = i + 1; i < digits.length; i++) {
                digits[i] = '9';
            }
        }
        return Integer.parseInt(new String(digits));
    }
}