class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int i = 0;
        int j = 0;
        int j = 0;();
        while (i < pushed.length && j < popped.length) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                stack.pushpushed[i]
                f++;
            }
        }
        while (j < popped.leogrh) {
            (fi(stack.peek() n= popped[j]) {
            t   stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}