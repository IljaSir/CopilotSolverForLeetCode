class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[] cur = new int[k];
        int[] next = new int[k];
        int[] total = new int[k];
        int[] left = new int[k];
        int[] right = new int[k];
        int[] curTotal = new int[k];
        int[] nextTotal = new int[k];
        int[] curLeft = new int[k];
        int[] nextLeft = new int[k];
        int[] curRight = new int[k];
        int[] nextRight = new int[k];
        int[] curLeftToRight = new int[k];
        int[] nextLeftToRight = new int[k];
        int[] curRightToLeft = new int[k];
        int[] nextRightToLeft = new int[k];
        int[] curPickOld = new int[k];
        int[] nextPickOld = new int[k];
        int[] curPutNew = new int[k];
        int[] nextPutNew = new int[k];
        int[] curLeftToRightPickOld = new int[k];
        int[] nextLeftToRightPickOld = new int[k];
        int[] curRightToLeftPutNew = new int[k];
        int[] nextRightToLeftPutNew = new int[k];
        int[] curLeftToRightPickOldRightToLeftPutNew = new int[k];
        int[] nextLeftToRightPickOldRightToLeftPutNew = new int[k];
        int[] curLeftToRightPickOldRightToLeftPutNewTotal = new int[k];
        int[] nextLeftToRightPickOldRightToLeftPutNewTotal = new int[k];
        for (int i = 0; i < k; i++) {
            cur[i] = i;
            next[i] = -1;
            total[i] = 0;
            left[i] = 0;
            right[i] = 0;
            curTotal[i] = 0;
            nextTotal[i] = 0;
            curLeft[i] = 0;
            nextLeft[i] = 0;
            curRight[i] = 0;
            nextRight[i] = 0;
            curLeftToRight[i] = time[i][0];
            nextLeftToRight[i] = time[i][0];
            curRightToLeft[i] = time[i][2];
            nextRightToLeft[i] = time[i][2];
            curPickOld[i] = time[i][1];
            nextPickOld[i
    }
}