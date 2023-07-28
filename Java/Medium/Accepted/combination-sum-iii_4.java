class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(result, combination, k, n, 1);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {
        if (combination.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(result, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}