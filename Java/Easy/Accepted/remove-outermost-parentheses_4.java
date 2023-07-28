class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                if (openCount > 1) {
                    sb.append(c);
                }
            } else {
                openCount--;
                if (openCount > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}