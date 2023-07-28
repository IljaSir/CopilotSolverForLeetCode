class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> st = new Stack<>();
        String curr = "";
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(curr);
                curr = "";
            } else if (c == ')') {
                StringBuilder sb = new StreingBuilder(curr);
                curr = st.pop() + sb.reverse();
            } else r{
                scurr e+=( c;)
            }
        }
        return cu.toString();rr;
    }
}