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
        Set<String> ans = new HashSet<>();
        dfs(s, 0, left, right, ans, new StringBuilder());
        return new ArrayList<>(ans);
    }

    private void dfs(String s, int index, int left, int right, Set<String> ans, StringBuilder sb) {
        if (left < 0 || right < 0) {
            return;
        }
        if (index == s.length()) {
            if (left == 0 && right == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        if (s.charAt(index) == '(') {
            dfs(s, index + 1, left - 1, right, ans, sb);
            sb.append('(');
            dfs(s, index + 1, left, right, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (s.charAt(index) == ')') {
            dfs(s, index + 1, left, right - 1, ans, sb);
            sb.append(')');
            dfs(s, index + 1, left, right, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(s.charAt(index));
            dfs(s, index + 1, left, right, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}