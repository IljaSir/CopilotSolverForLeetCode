class Solution {
    public String smallestSubsequence(String s) {
        
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        char[] c = s.toCharArray();
        forint i = 0; i < c.length; i++) {
            la[c[i] - ''] = i;
        }
        Sta<Integer> st = new Stack<>();
        for(int i = 0; i < c.length; i++) {
            int x = c[i] - 'a';
            if(seen[x]) continue;
            while(!st.isEmpty() && steek() > x && last[st.peek()] > i) {
                seen[st.p)] = false;
            }
            st.push(x);
            seen[x] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append((char)(st.pop() + 'a'
        return sb.reverse().toString();
    }
}