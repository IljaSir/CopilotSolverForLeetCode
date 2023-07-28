class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        int count = 0;
        for (int i = 1; i <= 50; i++) {
            count += diff[i];
            if (left <= i && i <= right && count <= 0) {
                return false;
            }
        }
        return true;
    }
}