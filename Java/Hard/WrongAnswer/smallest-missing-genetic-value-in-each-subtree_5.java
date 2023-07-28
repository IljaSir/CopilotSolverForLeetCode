class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) continue;
            map.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        int[] ans = new int[parents.length];
        boolean[] seen = new boolean[100001];
        for (int i = 0; i < nums.length; i++) {
            seen[nums[i]] = true;
        }
        dfs(map, 0, seen, ans);
        return ans;
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int i, boolean[] seen, int[] ans) {
        int min = 100001;
        for (int j = 1; j < seen.length; j++) {
            if (!seen[j]) {
                min = j;
                break;
            }
        }
        ans[i] = min;
        seen[min] = true;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                min = Math.min(min, dfs(map, j, seen, ans));
            }
        }
        seen[min] = false;
        return min;
    }
}