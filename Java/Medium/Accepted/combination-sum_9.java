class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void helper(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(candidates, target - candidates[i], i, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}