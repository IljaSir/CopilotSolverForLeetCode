class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        for(int push : pushed){
            s.push(push);
            while(!s.empty() && s.peek() == popped[i]){
                s.pop();
                i++;
            }
        }
        return s.empty();
    }
}