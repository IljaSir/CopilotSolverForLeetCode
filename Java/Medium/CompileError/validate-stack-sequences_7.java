class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            stack.push(pushed[j]);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();


        int i = 0;
    }
}