class Solution {
    public int minInsertions(String s) {
        
        int ans = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (open % 2 != 0) {
                    ans++;
                    open--;
                }
                open += 2;
            } else {
                open--;
                if (open < 0) {
                    ans++;
                    open += 2;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }
            }
        }
        ans += open;
        return ans;
    }
}