class Solution {
    public boolean isValid(String code) {
        
        if (code.length() < 7) return false;
        if (code.charAt(0) != '<' || code.charAt(1) == '/' || code.charAt(1) == '!' || code.charAt(code.length() - 1) != '>') return false;
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if (i > 0 && stack.isEmpty()) return false;
            if (code.charAt(i) == '<') {
                if (code.charAt(i + 1) == '/') {
                    int j = i + 2;
                    while (j < code.length() && code.charAt(j) != '>') j++;
                    if (j == code.length()) return false;
                    String tag = code.substring(i + 2, j);
                    if (tag.length() < 1 || tag.length() > 9) return false;
                    for (int k = 0; k < tag.length(); k++) {
                        if (tag.charAt(k) < 'A' || tag.charAt(k) > 'Z') return false;
                    }
                    if (stack.isEmpty() || !tag.equals(stack.pop())) return false;
                    i = j + 1;
                } else if (code.charAt(i + 1) == '!') {
                    if (code.charAt(i + 2) != '[' || code.charAt(i + 3) != 'C' || code.charAt(i + 4) != 'D' || code.charAt(i + 5) != 'A' || code.charAt(i + 6) != 'T' || code.charAt(i + 7) != 'A' || code.charAt(i + 8) != '[') return false;
                    int j = i + 9;
                    while (j < code.length() - 2) {
                        if (code.charAt(j) == ']' && code.charAt(j + 1) == ']' && code.charAt(j + 2) == '>') break;
                        j++;
                    }
                    if (j == code.length() - 2) return false;
                    i = j + 3;
                } else {
                    int j = i + 1;
                    while (j < code.length() && code.charAt(j) != '>') j++;
                    if (j == code.length()) return false;
                    String tag = code.substring(i + 1, j);
    }
}