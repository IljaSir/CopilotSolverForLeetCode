class Solution {
    public int countArrangement(int n) {
        
        int[] count = new int[]{0};
        boolean[] used = new boolean[n + 1];
        dfs(n, 1, count, used);
        return count[0];
    }
    private void dfs(int n, int pos, int[] count, boolean[] used) {
        if (pos > n) {
            count[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                dfs(n, pos + 1, count, used);
                used[i] = false;
            }
        }
    }
}