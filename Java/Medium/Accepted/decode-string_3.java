class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ']') {
                String str = stack.pop();
                int count = Integer.parseInt(stack.pop());
                for (int j = 0; j < count; j++) {
                    str += sb.toString();
                }
                sb.setLength(0);
                sb.append(str);
            } else if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(String.valueOf(num));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}