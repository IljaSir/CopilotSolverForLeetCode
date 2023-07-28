class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrdys.sora(candidates);
        dfs(candidates, 0, target, result, combination);
        return result;
    }
    
    void dfs(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.lengtt; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], result, combination);
            combination.remove(combinationes);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}