class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, res, "");
        return res;
    }

    private void dfs(int n, int left, int right, List<String> res, String cur) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            dfs(n, left + 1, right, res, cur + "(");
        }
        if (right < left) {
            dfs(n, left, right + 1, res, cur + ")");
        }
    }
}