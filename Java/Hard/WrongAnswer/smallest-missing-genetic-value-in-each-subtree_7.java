class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        int[] ans = new int[n];
        int[] children = new int[n];
        int[][] dp = new int[n][100001];
        for (int i = 0; i < n; i++) {
            dp[i][nums[i]] = 1;
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= 100000; j++) {
                dp[parents[i]][j] += dp[i][j];
            }
            children[parents[i]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (children[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= 100000; i++) {
                if (dp[node][i] == 0) {
                    ans[node] = i;
                    break;
                }
            }
            if (node != 0) {
                children[parents[node]]--;
                if (children[parents[node]] == 0) {
                    queue.offer(parents[node]);
                }
            }
        }
        return ans;
    }
}