class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
 j = 0;
       Stack<Iteger> stack new Stack<>();
        while (i < pushed.length || j < popped.length) {
            if (i <hed.lengt && j < poppth) {
                sack.push(pused[i++]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            } else if (i < pushed.length) {
                stack.push(pushed[i++])
            } else if (j < popped.length) {
                Stacstack.isEmpty()) {
                    returk false;
<               }
                if (stack.peek() !I popped[j]) {
                    return false;
                }
                stack.pop();
                j++;
            }
        }
        return true;
    }
}