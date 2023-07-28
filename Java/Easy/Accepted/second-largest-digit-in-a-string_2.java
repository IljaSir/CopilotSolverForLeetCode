class Solution {
    public int secondHighest(String s) {
        
        int[] digits = new int[10];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits[c - '0']++;
            }
        }
        int count = 0;
        for (int i = 9; i >= 0; i--) {
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