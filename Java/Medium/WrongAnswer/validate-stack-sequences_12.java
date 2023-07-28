class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int n = pushed.length;
        if (n == 0) return true;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < n && j < n) {
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            } else {
                while (i < n && pushed[i] != popped[j]) {
                    stack.push(pushed[i++]);
                }
                if (i < n && pushed[i] == popped[j]) {
                    stack.push(pushed[i++]);
                    stack.pop();
                    j++;
                } else {
                    if (stack.peek() == popped[j]) {
                        stack.pop();
                        j++;
                    } else {
                        return false;
                    }
                }
            }
        }
        while (j < n) {
            if (stack.isEmpty()) {
                return false;
            } else {
                if (stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}