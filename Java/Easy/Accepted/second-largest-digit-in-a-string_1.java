class Solution {
    public int secondHighest(String s) {
        
        int[] digits = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                digits[s.charAt(i) - '0']++;
            }
        }
        boolean found = false;
        for (int i = 9; i >= 0; i--) {
            if (digits[i] > 0) {
                if (found) {
                    return i;
                }
                found = true;
            }
        }
        return -1;
    }
}