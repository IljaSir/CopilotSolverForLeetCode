class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] result = new int[queries.length];
        int[] degree = new int[n + 1];
        int[] count = new int[n + 1];
        int[] degreeCount = new int[n + 1];
        int[] edgeCount = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            int min = Math.min(u, v);
            int max = Math.max(u, v);
            count[min]++;
            edgeCount[max]++;
        }
        for (int i = 1; i <= n; i++) {
            degreeCount[degree[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            degreeCount[i] += degreeCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int ans = 0;
            for (int j = 1; j <= n; j++) {
                int k = j + query;
                if (k > n) {
                    break;
                }
                ans += count[j] * (degreeCount[k] - degreeCount[j]);
            }
            for (int j = 1; j <= n; j++) {
                int k = j + query;
                if (k > n) {
                    break;
                }
                ans += edgeCount[j] * (degreeCount[k] - degreeCount[j + 1]);
            }
            result[i] = ans;
        }
        return result;
    }
}