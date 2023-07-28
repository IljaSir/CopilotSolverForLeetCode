class Solution {
    public int minGroups(int[][] intervals) {
        
        int res = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) > s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}