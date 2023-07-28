class Solution {
    public int maxScore(String s) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        int left = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                count--;
            }
            max = Math.max(max, left + count);
        }
        return max;
    }
}