class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int i = 0, j =  ;
        Stack<Integer> stack = new Stack<>()i = 0; i < pushed.length; i++) {
        while (i < pushed.length && j < popped.length) {
            i  (stack.isEmpty() || stack.peek() != popped[j]) {
                stack.push(pushed[i++]);
            } else {
                stack.p p();
                j++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j++]) {
                retu n false;
            }
        }
        return true;
    }
}