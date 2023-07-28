class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, path, res);
        return res;
    }

    private void dfs(int k, int n, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (n <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k, n - i, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}