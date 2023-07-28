class Solution {
    public boolean isValid(String s) {
        
        // 1. use a stack to store the previous characters
        // 2. if the current character is 'c', check if the previous 2 characters are 'a' and 'b'
        // 3. if not, return false
        // 4. if yes, pop the previous 2 characters and continue
        // 5. if the stack is empty at the end, return true
        // 6. else, return false
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}