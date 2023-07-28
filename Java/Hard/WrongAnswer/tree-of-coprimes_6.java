class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, nums, map, visited, ans);
        return ans;
    }
    
    private void dfs(int root, int[] nums, Map<Integer, List<Integer>> map, boolean[] visited, int[] ans) {
        int max = 0;
        for (int i = 1; i <= 50; i++) {
            if (gcd(i, nums[root]) == 1) {
                max = Math.max(max, i);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (gcd(i, nums[root]) == 1) {
                int ancestor = findAncestor(root, i, nums, map, visited);
                if (ancestor != -1) {
                    ans[root] = ancestor;
                    break;
                }
            }
        }
        for (int i : map.get(root)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, nums, map, visited, ans);
            }
        }
    }
    
    private int findAncestor(int root, int val, int[] nums, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (gcd(val, nums[root]) == 1) {
            return root;
        }
        for (int i : map.get(root)) {
            if (!visited[i]) {
                int ancestor = findAncestor(i, val, nums, map, visited);
                if (ancestor != -1) {
                    return ancestor;
                }
            }
        }
        return -1;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}