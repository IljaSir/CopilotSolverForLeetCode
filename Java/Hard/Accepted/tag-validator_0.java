class Solution {
    public boolean isValid(String code) {
        
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            if (i > 0 && stack.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) {
                    return false;
                }
                i += 2;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) {
                        return false;
                    }
                }
                String tag = code.substring(j, i);
                if (stack.isEmpty() || !stack.pop().equals(tag)) {
                    return false;
                }
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) {
                        return false;
                    }
                }
                stack.push(code.substring(j, i));
            }
        }
        return stack.isEmpty();
    }
}