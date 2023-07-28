class Solution {
    public int secondHighest(String s) {
        
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count[c - '0']++;
            }
        }
        int max = -1;
        int secondMax = -1;
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                if (i > max) {
                    secondMax = max;
                    max = i;
                } else if (i > secondMax) {
                    secondMax = i;
                }
            }
        }
        return secondMax;
    }
}