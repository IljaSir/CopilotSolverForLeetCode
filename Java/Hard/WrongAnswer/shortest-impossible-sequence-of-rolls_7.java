class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] count = new int[k + 1];
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        int[] min = new int[n + 1];
        int[] max = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (count[rolls[i]]++ == 0 ? 1 : 0);
        }
        Arrays.fill(count, 0);
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (count[rolls[i]]++ == 0 ? 1 : 0);
        }
        min[0] = max[0] = 0;
        for (int i = 1; i <= n; i++) {
            min[i] = Math.min(min[i - 1], prefix[i]);
            max[i] = Math.max(max[i - 1], prefix[i]);
        }
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int m = l + r >> 1;
                if (prefix[m] - prefix[i] - (max[m] - max[i]) <= k) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (l > i + 1) {
                int len = l - i - 1;
                if (prefix[l - 1] - prefix[i] - (max[l - 1] - max[i]) <= k) {
                    len += suffix[l - 1];
                }
                ans = Math.min(ans, len);
            }
        }
        return ans > n ? -1 : ans;
    }
}