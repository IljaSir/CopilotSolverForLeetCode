class Solution {
    public int secondHighest(String s) {
        
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count[s.charAt(i) - '0']++;
            }
        }
        
        int max = -1;
        int secondMax = -1;
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                if (max == -1) {
                    max = i;
                } else if (secondMax == -1) {
                    secondMax = i;
                    break;
                }
            }
        }
        return secondMax;
    }
}