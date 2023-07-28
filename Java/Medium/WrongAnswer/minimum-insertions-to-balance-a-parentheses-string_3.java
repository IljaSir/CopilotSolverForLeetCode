class Solution {
    public int minInsertions(String s) {
        
        int result = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    result++;
                }
                if (open > 0) {
                    open--;
                    result--;
                } else {
                    result++;
                }
            }
        }
        return result + open * 2;
    }
}