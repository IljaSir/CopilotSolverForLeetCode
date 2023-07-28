class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0) return ans;
        Arrays.sort(candidates);
        dfs(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int start) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, list, i);
            list.remove(list.size() - 1);
        }
    }
}