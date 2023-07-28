class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        if (n < 1 || k < 1 || k > n) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(result, comb, 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(result, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}