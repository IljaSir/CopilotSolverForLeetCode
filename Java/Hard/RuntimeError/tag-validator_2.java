class Solution {
    public boolean isValid(String code) {
        
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < code.length()) {
            if (i > 0 && stack.isEmpty()) return false;
            else if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            }
            else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++)
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                String startTag = stack.pop();
                if (!startTag.equals(code.substring(j, i))) return false;
                i++;
            }
            else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++)
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                stack.push(code.substring(j, i));
                i++;
            }
            else i++;
        }
        return stack.isEmpty();
    }
}