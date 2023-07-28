class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int n = pairs.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = pairs[i][0];
            end[i] = pairs[i][1];
        }
        int[][] ans = new int[n][2];
        Arrays.sort(start);
        Arrays.sort(end);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] == end[j]) {
                ans[i][0] = start[i];
                ans[i][1] = end[j];
                j++;
            } else {
                ans[i][0] = end[j];
                ans[i][1] = start[i];
            }
        }
        return ans;
    }
}