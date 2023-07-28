class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        for (int i = 0; i <= n; i++) {
            int l = Math.max(0, i - ranges[i]);
            int r = Math.min(n, i + ranges[i]);
            left[l] = Math.min(left[l], l);
            right[r] = Math.max(right[r], r);
        }
        int ans = 0;
        int cur = 0;
        while (cur < n) {
            int next = cur;
            for (int i = left[cur]; i <= cur; i++) {
                next = Math.max(next, right[i]);
            }
            if (next == cur) {
                return -1;
            }
            cur = next;
            ans++;
        }
        return ans;
    }
}