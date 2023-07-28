class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 0 || n == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, ans);
        return ans;
    }

    private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}