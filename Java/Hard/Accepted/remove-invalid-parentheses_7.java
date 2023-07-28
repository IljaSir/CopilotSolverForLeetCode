class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> ans = new ArrayList<>();
        dfs(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    private void dfs(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            dfs(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}