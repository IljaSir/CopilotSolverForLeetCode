class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] res = new int[queries.length];
        int[] degree = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            degree[u]++;
            degree[v]++;
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }
            map.put(u * n + v, map.getOrDefault(u * n + v, 0) + 1);
        }
        int[] count = new int[n + 1];
        for (int i : degree) {
            count[i]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int ans = 0;
            for (int j = 0; j < n; j++) {
                int left = Math.max(0, q - degree[j] + 1);
                int right = Math.min(degree[j], q);
                ans += count[left] - count[right + 1];
                if (q - degree[j] <= degree[j] && q - degree[j] > 0) {
                    int u = j;
                    int v = q - degree[j];
                    if (u > v) {
                        int temp = u;
                        u = v;
                        v = temp;
                    }
                    ans -= map.getOrDefault(u * n + v, 0);
                }
            }
            res[i] = ans / 2;
        }
        return res;
    }
}