class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] len = new int[n+2];
        int[] cnt = new int[n+1];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int l = len[a-1], r = len[a+1];
            len[a] = len[a-l] = len[a+r] = l+r+1;
            cnt[l]--; cnt[r]--; cnt[len[a]]++;
            if (cnt[m] > 0) {
                res = i+1;
            }
        }
        return res;
    }
}