class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        int[] ans = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(parents[i], new HashSet<>());
            map.get(parents[i]).add(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] missing = new int[n];
        for (int i = 1; i <= 100000; i++) {
            if (!set.contains(i)) {
                missing[i - 1] = i;
            }
        }
        dfs(map, ans, missing, 0, new HashSet<>());
        return ans;
    }
    
    private int dfs(Map<Integer, Set<Integer>> map, int[] ans, int[] missing, int node, Set<Integer> set) {
        int min = 100000;
        for (int child : map.getOrDefault(node, new HashSet<>())) {
            min = Math.min(min, dfs(map, ans, missing, child, set));
        }
        if (missing[nums[node] - 1] == nums[node]) {
            ans[node] = missing[min - 1];
            set.add(nums[node]);
            while (set.contains(min)) {
                min++;
            }
        } else {
            ans[node] = missing[nums[node] - 1];
        }
        return min;
    }
}