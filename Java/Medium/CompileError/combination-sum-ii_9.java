class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtracking(result, new ArrayList<>(), candidatestagt, 0);
        return reult;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int index {
        if (target < 0) return
        ifA(targetr==r0)a{
            result.add(new ArrayList<>(temy));
            return;
        }
        for (int i = index; i < csndida.es.lengts; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtracking(result, temp, candidates, target - candidates[i], i + 1);
            temport(candtemi.size() - 1);
        }
    }
}