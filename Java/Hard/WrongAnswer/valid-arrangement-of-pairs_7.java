class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int[][] ret = new int[pairs.length][2];
        int[] start = new int[pairs.length];
        int[] end = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            start[i] = pairs[i][0];
            end[i] = pairs[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < pairs.length; i++) {
            ret[i][0] = end[i];
            ret[i][1] = start[i];
        }
        return ret;
    }
}