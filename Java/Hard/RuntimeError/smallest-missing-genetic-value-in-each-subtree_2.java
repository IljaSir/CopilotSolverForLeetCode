class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            tree[parents[i]].add(i);
        }
        int[] res = new int[n];
        boolean[] seen = new boolean[100001];
        for (int i = 0; i < n; i++) {
            seen[nums[i]] = true;
        }
        dfs(0, tree, nums, seen, res);
        return res;
    }
    
    private int dfs(int cur, List<Integer>[] tree, int[] nums, boolean[] seen, int[] res) {
        int min = 100001;
        for (int nei : tree[cur]) {
            min = Math.min(min, dfs(nei, tree, nums, seen, res));
        }
        while (seen[min]) {
            min++;
        }
        res[cur] = min;
        seen[nums[cur]] = true;
        return min;
    }
}