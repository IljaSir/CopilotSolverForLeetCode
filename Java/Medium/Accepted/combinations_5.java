class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> combinations = new ArrayList<>();
        if (n < 1 || k < 1) {
            return combinations;
        }
        List<Integer> combination = new ArrayList<>();
        dfs(n, k, 1, combination, combinations);
        return combinations;
    }

    private void dfs(int n, int k, int index, List<Integer> combination, List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i <= n; i++) {
            combination.add(i);
            dfs(n, k, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}