class Solution {
    public int maxScore(String s) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        int temp = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                temp++;
            } else {
                count--;
            }
            max = Math.max(max, temp + count);
        }
        return max;
    }
}