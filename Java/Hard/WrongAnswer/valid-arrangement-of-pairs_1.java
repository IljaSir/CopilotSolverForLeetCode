class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int n = pairs.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = pairs[i][0];
            end[i] = pairs[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[][] res = new int[n][2];
        for(int i = 0; i < n; i++){
            res[i][0] = start[i];
            res[i][1] = end[i];
        }
        return res;
    }
}