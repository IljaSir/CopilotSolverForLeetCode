class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 3 != 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (stack.isEmpty() || stack.pop() != 1) {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 0) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i) - 'a');
            }
        }
        return stack.isEmpty();
    }
}