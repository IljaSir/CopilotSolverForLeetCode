class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        
        int n = edges.length + 1;
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = degree[i] == 1 ? 1 : 0;
        }
        for (int[] guess : guesses) {
            if (root[guess[0]] == 0) {
                root[guess[0]] = 2;
            }
            if (root[guess[1]] == 0) {
                root[guess[1]] = 2;
            }
        }
        int[] count = new int[n];
        for (int[] guess : guesses) {
            if (root[guess[0]] == 1) {
                count[guess[1]]++;
            }
            if (root[guess[1]] == 1) {
                count[guess[0]]++;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] == k) {
                result++;
            }
        }
        return result;
    }
}