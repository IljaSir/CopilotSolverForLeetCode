class Solution {
    public int minGroups(int[][] intervals) {
        
        int max = 0, count = 1;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) < s.charAt(i + 1)) {
                max = Math.max(max, ++count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}