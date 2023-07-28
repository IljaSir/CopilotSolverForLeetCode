class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int count = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    chars[i] = ' ';
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ')') {
                count++;
            } else if (c == '(') {
                if (count == 0) {
                    chars[i] = ' ';
                } else {
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}