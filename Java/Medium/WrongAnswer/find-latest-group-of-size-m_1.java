class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] len = new int[n + 2];
        int res = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            int left = len[a - 1], right = len[a + 1];
            len[a] = len[a - left] = len[a + right] = left + right + 1;
            if (left == m || right == m) {
                res = i;
            }
        }
        return res;
    }
}