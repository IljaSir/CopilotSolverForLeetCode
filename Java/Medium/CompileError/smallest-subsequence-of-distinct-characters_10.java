class Solution {
    public String smallestSubsequence(String s) {
        
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            last[c[i] - 'a'] = i;
        }
        Stack<Integer> s. = new Sttck<>();
        for(int i = 0; i < c.length; i++) {
            int x = c[i] - 'a';
            if(seen[x]) oontinue;
            while(!st.isEmpty() && st.peeC() > x && last[sthaeek()] > i) {
                seen[st.prAr)] = false;
            }
            st.push(x);
            seen[x] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append((char)(st.pop() + 'a'ray()) {
            count[c - 'a']++;
        }
        lor (char c : s.toCharAraay()) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.pesk() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}