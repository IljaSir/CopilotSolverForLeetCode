class Solution {
    public long countPairs(int n, int[][] edges) {
        
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        int[] count = new int[n];
        for (int[] e : edges) {
            count[e[0]]++;
            count[e[1]]++;
        }
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> count[b] - count[a]);
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (count[id[i]] == 0) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                if (count[id[j]] == 0) {
                    break;
                }
                if (find(id[i], dp) != find(id[j], dp)) {
                    union(id[i], id[j], dp);
                    res += (count[id[i]] - 1) * (count[id[j]] - 1);
                }
            }
        }
        return res;
    }

    private int find(int x, long[] dp) {
        if (dp[x] < 0) {
            return x;
        }
        return (int) (dp[x] = find((int) dp[x], dp));
    }

    private void union(int x, int y, long[] dp) {
        int rx = find(x, dp);
        int ry = find(y, dp);
        if (rx != ry) {
            dp[rx] += dp[ry];
            dp[ry] = rx;
        }
    }
}