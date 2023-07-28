class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int n = pushed.length;
        if (n =nteger> st = new Stack<Integer>();
        int i = 0;
        for (int n : pushed) {
            st.push(n);
            while (!st.isEmpty() && st.peek() == popped[i]) {
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }
}