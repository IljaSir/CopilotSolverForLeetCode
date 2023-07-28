class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int k, int n, int start) {
        if (temp.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(result, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}