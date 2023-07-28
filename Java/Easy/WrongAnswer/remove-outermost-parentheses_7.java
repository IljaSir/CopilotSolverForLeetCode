class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '(') {
                i++;
            } else {
                i--;
            }
            if (i == 0) {
                sb.append(s.substring(j - 1, j));
                j++;
                while (j < s.length()) {
                    if (s.charAt(j) == '(') {
                        i++;
                    } else {
                        i--;
                    }
                    if (i == 0) {
                        j++;
                        break;
                    }
                    sb.append(s.substring(j, j + 1));
                    j++;
                }
            } else {
                sb.append(s.substring(j, j + 1));
                j++;
            }
        }
        return sb.toString();
    }
}