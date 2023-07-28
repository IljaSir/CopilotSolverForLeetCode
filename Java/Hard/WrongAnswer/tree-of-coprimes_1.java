class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        dfs(nums, graph, 0, -1, map, res, visited);
        return res;
    }

    private void dfs(int[] nums, Map<Integer, List<Integer>> graph, int cur, int parent, Map<Integer, List<Integer>> map, int[] res, boolean[] visited) {
        visited[cur] = true;
        for (int i = 1; i <= 50; i++) {
            if (nums[cur] % i == 0 && map.containsKey(i)) {
                for (int j : map.get(i)) {
                    if (j == cur) continue;
                    if (visited[j]) {
                        if (parent == -1 || nums[j] > nums[parent]) {
                            parent = j;
                        }
                    }
                }
            }
        }
        if (parent != -1) {
            res[cur] = parent;
        }
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            if (visited[next]) continue;
            dfs(nums, graph, next, parent, map, res, visited);
        }
    }
}