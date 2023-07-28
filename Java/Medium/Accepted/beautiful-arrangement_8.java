class Solution {
    public int countArrangement(int n) {
        
        return countArrangement(n, 1, new int[n]);
    }
    public int countArrangement(int n, int pos, int[] visited) {
        if (pos > n) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i - 1] == 0 && (i % pos == 0 || pos % i == 0)) {
                visited[i - 1] = pos;
                count += countArrangement(n, pos + 1, visited);
                visited[i - 1] = 0;
            }
        }
        return count;
    }
}