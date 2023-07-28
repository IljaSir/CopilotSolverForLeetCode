class Solution {
    public boolean isValid(String code) {
        
        if (code.charAt(0) != '<') return false;
        if (code.charAt(code.length() - 1) != '>') return false;
        if (!Character.isUpperCase(code.charAt(1))) return false;
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if (code.charAt(i) == '<') {
                if (i + 1 < code.length() && code.charAt(i + 1) == '!') {
                    if (i + 9 < code.length() && code.substring(i, i + 9).equals("<![CDATA[")) {
                        int j = i + 9;
                        while (j + 3 < code.length() && !code.substring(j, j + 3).equals("]]>")) {
                            j++;
                        }
                        if (j + 3 > code.length()) return false;
                        i = j + 2;
                    } else {
                        return false;
                    }
                } else if (i + 1 < code.length() && code.charAt(i + 1) == '/') {
                    int j = i + 2;
                    while (j < code.length() && code.charAt(j) != '>') {
                        j++;
                    }
                    if (j >= code.length()) return false;
                    String tag = code.substring(i + 2, j);
                    if (tag.length() < 1 || tag.length() > 9) return false;
                    if (stack.isEmpty() || !stack.pop().equals(tag)) return false;
                    i = j;
                } else {
                    int j = i + 1;
                    while (j < code.length() && code.charAt(j) != '>') {
                        j++;
                    }
                    if (j >= code.length()) return false;
                    String tag = code.substring(i + 1, j);
                    if (tag.length() < 1 || tag.length() > 9) return false;
                    for (int k = 0; k < tag.length(); k++) {
                        if (!Character.isUpperCase(tag.charAt(k))) return false;
                    }
                    stack.push(tag);
                    i = j;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}