class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}