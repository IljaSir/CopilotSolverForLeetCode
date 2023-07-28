class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degree = new int[n + 1];
        for (List<Integer> edge: edges) {
            degree[edge.get(0)]++;
            degree[edge.get(1)]++;
        }
        int odds = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odds++;
            }
        }
        if (odds == 0 || odds == 2) {
            return true;
        }
        return false;
    }
}