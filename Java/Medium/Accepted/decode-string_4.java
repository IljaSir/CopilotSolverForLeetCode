class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (Character.isDigit(s.charAt(j))) {
                    j++;
                }
                stack.push(s.substring(i, j));
                i = j;
            } else if (s.charAt(i) == '[') {
                stack.push("[");
                i++;
            } else if (s.charAt(i) == ']') {
                String str = "";
                while (!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                int count = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < count; k++) {
                    sb.append(str);
                }
                stack.push(sb.toString());
                i++;
            } else {
                stack.push(s.substring(i, i + 1));
                i++;
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}