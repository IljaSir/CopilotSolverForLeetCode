class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] ans = new int[n-1];
        for (int i = 1; i < (1 << n); i++) {
            int[] degree = new int[n];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt++;
                    for (int[] edge : edges) {
                        if (((i >> (edge[0] - 1)) & 1) == 1 && ((i >> (edge[1] - 1)) & 1) == 1) {
                            degree[edge[0] - 1]++;
                            degree[edge[1] - 1]++;
                        }
                    }
                }
            }
            if (cnt > 1) {
                int max = 0;
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {
                        max = Math.max(max, degree[j]);
                    }
                }
                if (max == cnt - 1) {
                    ans[cnt - 2]++;
                }
            }
        }
        return ans;
    }
}