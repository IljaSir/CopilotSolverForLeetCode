class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, left, right, 0, new StringBuilder(), res);
        return new ArrayList<>(res);
    }
    private void dfs(String s, int i, int left, int right, int open, StringBuilder sb, Set<String> res) {
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            dfs(s, i + 1, left - 1, right, open, sb, res);
            dfs(s, i + 1, left, right, open + 1, sb.append(c), res);
        } else if (c == ')') {
            dfs(s, i + 1, left, right - 1, open, sb, res);
            dfs(s, i + 1, left, right, open - 1, sb.append(c), res);
        } else {
            dfs(s, i + 1, left, right, open, sb.append(c), res);
        }
        sb.setLength(len);
    }
}