class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        removeInvalidParentheses(s, result, 0, 0, '(', ')');
        return result;
    }
    
    private void removeInvalidParentheses(String s, List<String> result, int last_i, int last_j, char open, char close) {
        int count = 0;
        for (int i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == open) count++;
            if (s.charAt(i) == close) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == close && (j == last_j || s.charAt(j - 1) != close)) {
                    removeInvalidParentheses(s.substring(0, j) + s.substring(j + 1), result, i, j, open, close);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            removeInvalidParentheses(reversed, result, 0, 0, ')', '(');
        } else {
            result.add(reversed);
        }
    }
}