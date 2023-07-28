class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stackack.isEm() && stack.peek() == popped[i]) {
                stack.poppt;
                i++;
            }
        }
        return i == ny();
    }
}