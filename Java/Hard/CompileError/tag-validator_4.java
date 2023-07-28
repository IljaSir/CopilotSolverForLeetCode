class Solution {
    public boolean isValid(String code) {
        
        if (code.length() < 7) {
            return false;
        }
        if (code.charAt(0) != '<' || code.charAt(1) != '!' || code.charAt(2) != '[' || code.charAt(3) != 'C' || code.charAt(4) != 'D' || code.charAt(5) != 'A' || code.charAt(6) != 'T' || code.charAt(7) != 'A' || code.charAt(8) != '[') {
            return false;
        }
        int i = 9;
        int n = code.length();
        Stack<String> stack = new Stack<>();
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (code.charAt(i + 1) == '/') {
                    int j = i + 2;
                    while (j < n && code.charAt(j) != '>') {
                        j++;
                    }
                    if (j == n) {
                        return false;
                    }
                    String name = code.substring(i + 2, j);
                    if (name.length() == 0 || name.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < name.length(); k++) {
                        if (name.charAt(k) < 'A' || name.charAt(k) > 'Z') {
                            return false;
                        }
                    }
                    if (stack.isEmpty() || !stack.peek().equals(name)) {
                        return false;
                    }
                    stack.pop();
                    i = j + 1;
                } else {
                    int j = i + 1;
                    while (j < n && code.charAt(j) != '>') {
                        j++;
                    }
                    if (j == n) {
                        return false;
                    }
                    String name = code.substring(i + 1, j);
                    if (name.length() == 0 || name.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < name.length(); k++) {
                        if (name.charAt(k) < 'A' || name.charAt(k) > 'Z') {
                            return false;
                        }
                    }
                    stack.push(name);
                    i = j + 1;
                }
            } else if (code.charAt(i) == '!' && code.charAt(i + 1) == '[' && code.charAt(i + 2
    }
}