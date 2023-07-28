class Solution {
    public int countArrangement(int n) {
        
        int[] count = new int[1];
        count[0] = 0;
        boolean[] visited = new boolean[n + 1];
        helper(n, 1, count, visited);
        return count[0];
    }
    
    private void helper(int n, int pos, int[] count, boolean[] visited) {
        if (pos > n) {
            count[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                helper(n, pos + 1, count, visited);
                visited[i] = false;
            }
        }
    }
}