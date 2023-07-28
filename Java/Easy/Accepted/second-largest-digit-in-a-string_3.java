class Solution {
    public int secondHighest(String s) {
        
        int[] digits = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digits[ch - '0']++;
            }
        }
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > 0) {
                count++;
                if (count == 2) {
                    return i;
                }
            }
        }
        return -1;
    }
}