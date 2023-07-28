class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        
        int n = edges.length + 1;
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[] roots = new int[n];
        for (int[] guess : guesses) {
            if (degree[guess[0]] == 1) {
                roots[guess[0]]++;
            }
            if (degree[guess[1]] == 1) {
                roots[guess[1]]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (roots[i] >= k) {
                count++;
            }
        }
        return count;
    }
}