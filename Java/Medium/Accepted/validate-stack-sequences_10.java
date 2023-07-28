class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length || j < popped.length) {
            if (i < pushed.length && j < popped.length) {
                stack.push(pushed[i++]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            } else if (i < pushed.length) {
                stack.push(pushed[i++]);
            } else if (j < popped.length) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != popped[j]) {
                    return false;
                }
                stack.pop();
                j++;
            }
        }
        return true;
    }
}