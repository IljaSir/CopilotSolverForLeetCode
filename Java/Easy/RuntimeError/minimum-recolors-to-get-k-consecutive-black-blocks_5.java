class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        char[] s = blocks.toCharArray();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (s[i] == 'B' ? 1 : 0);
        }
        int[] f = new int[n + 1];
        int res = n;
        for (int i = 0; i <= n - k; i++) {
            int l = i, r = n - k + 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (pre[mid + k] - pre[mid] >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (pre[l + k] - pre[l] >= k) {
                res = Math.min(res, f[l] + pre[i + k] - pre[i] + pre[n] - pre[l + k]);
            }
            f[i + 1] = f[i] + (s[i] == 'W' ? 1 : 0);
        }
        return res;
    }
}