class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        remove(s, 0, 0, result, '(', ')');
        return result;
    }

    private void remove(String s, int start, int lastRemove, List<String> result, char open, char close) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                count++;
            } else if (s.charAt(i) == close) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            for (int j = lastRemove; j <= i; j++) {
                if (s.charAt(j) == close && (j == lastRemove || s.charAt(j - 1) != close)) {
                    remove(s.substring(0, j) + s.substring(j + 1), i, j, result, open, close);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            remove(reversed, 0, 0, result, close, open);
        } else {
            result.add(reversed);
        }
    }
}