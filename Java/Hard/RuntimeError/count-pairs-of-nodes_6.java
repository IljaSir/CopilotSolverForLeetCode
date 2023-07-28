class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] degree = new int[n];
        int[] count = new int[n];
        int[] result = new int[queries.length];
        
        for (int[] edge : edges) {
            degree[edge[0] - 1]++;
            degree[edge[1] - 1]++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count[degree[i] + degree[j]]++;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        
        for (int i = 0; i < queries.length; i++) {
            result[i] = count[queries[i] + 1];
        }
        
        return result;
    }
}