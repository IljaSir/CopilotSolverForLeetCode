class Solution {
    public boolean isValid(String code) {
        
        int n = code.length();
        if (n == 0) {
            return true;
        }
        if (code.charAt(0) != '<') {
            return false;
        }
        int i = 0;
        Deque<String> stack = new LinkedList<>();
        while (i < n) {
            if (i > 0 && stack.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i == -1) {
                    return false;
                }
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i == -1 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; ++k) {
                    if (!Character.isUpperCase(code.charAt(k))) {
                        return false;
                    }
                }
                String startTag = stack.pop();
                if (!startTag.equals(code.substring(j, i))) {
                    return false;
                }
                i++;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i == -1 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; ++k) {
                    if (!Character.isUpperCase(code.charAt(k))) {
                        return false;
                    }
                }
                stack.push(code.substring(j, i));
                i++;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}