class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String str = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                int base = 1;
                int num = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num += (stack.pop().charAt(0) - '0') * base;
                    base *= 10;
                }
                String tmp = "";
                while (num > 0) {
                    tmp += str;
                    num--;
                }
                stack.push(tmp);
            } else {
                stack.push(s.charAt(i) + "");
            }
        }
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans0; j < num; j++) {
                    temp.append(res);
                };
            }
        }
        return sb.toString();
    }
}