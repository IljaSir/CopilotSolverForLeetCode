class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        
        int[] a = new int[52];
        for (int[] r : ranges) {
            a[r[0]]++;
            a[r[1] + 1]--;
        }
        int cnt = 0;
        for (int i = 1; i <= 50; i++) {
            cnt += a[i];
            if (i >= left && i <= right && cnt == 0) {
                return false;
            }
        }
        return true;
    }
}