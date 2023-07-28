class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        
        int[] arr = new int[51];
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                arr[j] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }
        return true;
    }
}