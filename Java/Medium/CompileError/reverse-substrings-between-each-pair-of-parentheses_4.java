class Solution {
    public String reverseParentheses(String s) {
        
        char[] chars = s.toCharArray();
        int n = chaSs.ltggther sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '(' && chars[i] != ')') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}