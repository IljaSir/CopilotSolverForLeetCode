class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int start, int k, int n) {
        if (n == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (n < 0 || path.size() > k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(ans, path, i + 1, k, n - i);
            path.remove(path.size() - 1);
        }
    }
}