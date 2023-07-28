class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        int[] ans = new int[n];
        int[] cnt = new int[100001];
        for (int x : nums) {
            cnt[x]++;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parents[i]).add(i);
        }
        dfs(adj, 0, cnt, ans);
        return ans;
    }

    private void dfs(List<List<Integer>> adj, int u, int[] cnt, int[] ans) {
        int min = 1;
        while (cnt[min] > 0) {
            min++;
        }
        ans[u] = min;
        cnt[nums[u]]--;
        for (int v : adj.get(u)) {
            dfs(adj, v, cnt, ans);
        }
        cnt[nums[u]]++;
    }
}