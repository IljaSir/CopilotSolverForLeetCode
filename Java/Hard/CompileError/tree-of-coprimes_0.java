class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        dfs(graph, nums, res, 0, new int[51], new int[51]);
        return res;
    }

    private void dfs(List<Integer>[] graph, int[] nums, int[] res, int cur, int[] depth, int[] pre) {
        int d = depth[nums[cur]];
        depth[nums[cur]] = cur + 1;
        for (int i = 1; i <= 50; i++) {
            if (depth[i] > 0 && gcd(i, nums[cur]) == 1) {
                if (res[cur] == -1 || depth[i] > depth[nums[res[cur]]]) {
                    res[cur] = pre[i] - 1;
                }
            }
        }
        for (int next : graph[cur]) {
            if (depth[nums[next]] == 0) {
                pre[nums[next]] = cur + 1;
                dfs(graph, nums, res, next, depth, pre);
            }
        }
        depth[nums[cur]] = d;
    }
}