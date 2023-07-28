class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) return result;
        if (k > n) return result;
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, result);
        return result;
    }
    public void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
    }
}