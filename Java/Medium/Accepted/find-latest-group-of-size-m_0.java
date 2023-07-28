class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] len = new int[n + 2];
        int[] cnt = new int[n + 1];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int left = len[a - 1];
            int right = len[a + 1];
            len[a - left] = len[a + right] = left + right + 1;
            cnt[left]--;
            cnt[right]--;
            cnt[left + right + 1]++;
            if (cnt[m] > 0) {
                res = i + 1;
            }
        }
        return res;
    }
}