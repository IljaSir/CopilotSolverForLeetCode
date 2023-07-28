class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == 'c'){
                if(st.isEmpty() || st.pop() != 'b') return false;
                if(st.isEmpty() || st.pop() != 'a') return false;
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}