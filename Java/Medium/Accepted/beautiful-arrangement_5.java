class Solution {
    public int countArrangement(int n) {
        
        int[] result = new int[1];
        boolean[] visited = new boolean[n + 1];
        dfs(n, 1, result, visited);
        return result[0];
    }
    
    private void dfs(int n, int index, int[] result, boolean[] visited) {
        if (index > n) {
            result[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                dfs(n, index + 1, result, visited);
                visited[i] = false;
            }
        }
    }
}