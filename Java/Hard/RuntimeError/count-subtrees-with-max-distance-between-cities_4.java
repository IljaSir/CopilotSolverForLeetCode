class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] res = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int[] dist = new int[n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    count++;
                    for (int k = j + 1; k < n; k++) {
                        if (((i >> k) & 1) == 1) {
                            dist[k] = dist[j] + 1;
                        }
                    }
                }
            }
            for (int[] e : edges) {
                if (((i >> (e[0] - 1)) & 1) == 1 && ((i >> (e[1] - 1)) & 1) == 1) {
                    dist[e[1] - 1] = Math.max(dist[e[1] - 1], dist[e[0] - 1] + 1);
                    dist[e[0] - 1] = Math.max(dist[e[0] - 1], dist[e[1] - 1] + 1);
                }
            }
            int max = 0;
            for (int d : dist) {
                max = Math.max(max, d);
            }
            if (max < n) {
                res[max - 1] += (1 << (count - 1));
            }
        }
        return res;
    }
}