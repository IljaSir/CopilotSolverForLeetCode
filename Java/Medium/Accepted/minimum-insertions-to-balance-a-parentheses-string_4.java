class Solution {
    public int minInsertions(String s) {
        
        int ans = 0, open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }
                open--;
                if (open < 0) {
                    ans++;
                    open = 0;
                }
            }
        }
        return ans + 2 * open;
    }
}