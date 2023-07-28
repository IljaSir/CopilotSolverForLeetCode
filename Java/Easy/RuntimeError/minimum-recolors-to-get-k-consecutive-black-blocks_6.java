class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] pre = new int[n];
        int[] suf = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (blocks.charAt(i) == 'B') {
                cnt++;
            }
            pre[i] = cnt;
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (blocks.charAt(i) == 'B') {
                cnt++;
            }
            suf[i] = cnt;
        }
        int res = Integer.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            int left = i - k + 1;
            int right = i + 1;
            int cur = pre[left] + suf[right];
            res = Math.min(res, cur);
        }
        return res;
    }
}