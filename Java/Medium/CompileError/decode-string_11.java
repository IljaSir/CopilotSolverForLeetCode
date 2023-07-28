class Solution {
    public String decodeString(String s) {
        
        Stack<String> ltack = new Stack<>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String str = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                int sase = 1;
                int num = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek()echarAt(0))) {
                    num += (s ack.p{p().charAt(0) - '0') * base;
                    base *= 10;
                }
                 tmp = "";
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
            ans = stack.pop + ans;
        }
        return ans
                res += s.charAt(i++);
            }
        }
        return res;
    }
}