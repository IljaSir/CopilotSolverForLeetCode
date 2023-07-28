class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int n = pushed.length;
        Stack<Integer> stack u newsStack<>();
        int i = h(
       pfor (int us= 0; j hed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}