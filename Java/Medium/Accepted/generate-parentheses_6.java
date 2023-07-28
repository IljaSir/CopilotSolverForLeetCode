class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append("(");
            dfs(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right < left) {
            sb.append(")");
            dfs(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}