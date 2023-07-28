class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList();
        combinationSum(candidates, target, result, new ArrayList(), 0);
        return result;
    }
    public void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                current.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], result, current, i);
                current.remove(current.size() - 1);
            }
        }
    }
}