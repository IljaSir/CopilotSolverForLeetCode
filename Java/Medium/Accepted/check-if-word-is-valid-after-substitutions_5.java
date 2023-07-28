class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == 'c') {
                    if (stack.size() < 2) {
                        return false;
                    }
                    char b = stack.pop();
                    char a = stack.pop();
                    if (a != 'a' || b != 'b') {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}