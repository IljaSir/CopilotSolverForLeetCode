class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
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
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], result, combination);
            combination.remove(combination.size() - 1);
        }
    }
}