class Solution {
    public int minGroups(int[][] intervals) {
        
        int n = s.length();
        int max = 0;
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) - s.charAt(i - 1) == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}