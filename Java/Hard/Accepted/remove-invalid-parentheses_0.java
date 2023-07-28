class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, left, right, 0, new StringBuilder(), res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int index, int left, int right, int pair, StringBuilder sb, Set<String> res) {
        if (index == s.length()) {
            if (left == 0 && right == 0 && pair == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            if (left > 0) {
                dfs(s, index + 1, left - 1, right, pair, sb, res);
            }
            dfs(s, index + 1, left, right, pair + 1, sb.append(c), res);
        } else if (c == ')') {
            if (right > 0) {
                dfs(s, index + 1, left, right - 1, pair, sb, res);
            }
            if (pair > 0) {
                dfs(s, index + 1, left, right, pair - 1, sb.append(c), res);
            }
        } else {
            dfs(s, index + 1, left, right, pair, sb.append(c), res);
        }
        sb.setLength(len);
    }
}