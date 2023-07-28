class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] result = new int[queries.length];
        int[] counter = new int[n + 1];
        int[][] incident = new int[n + 1][n + 1];
        int[] edgesCounter = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            counter[edges[i][0]]++;
            counter[edges[i][1]]++;
            incident[edges[i][0]][edges[i][1]]++;
            incident[edges[i][1]][edges[i][0]]++;
        }
        for (int i = 0; i < edges.length; i++) {
            edgesCounter[i] = counter[edges[i][0]] + counter[edges[i][1]] - incident[edges[i][0]][edges[i][1]];
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int sum = 0;
            for (int j = 0; j < edges.length; j++) {
                if (edgesCounter[j] > q) {
                    sum++;
                }
            }
            result[i] = sum;
        }
        return result;
    }
}