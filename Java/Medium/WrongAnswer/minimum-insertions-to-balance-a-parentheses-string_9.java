class Solution {
    public int minInsertions(String s) {
        
        int open = 0;
        int close = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                if (close % 2 == 1) {
                    close--;
                    open++;
                    res++;
                }
            } else {
                close++;
                if (close == 2) {
                    close = 0;
                    open--;
                }
            }
            if (open < 0) {
                open += 2;
                res += 2;
            }
        }
        return res + open * 2;
    }
}