class Solution {
    public String removeDuplicateLetters(String s) {
        
        Stack<Character> stack = new Stack<>();
    boolean[]visited=newoolean[26];
        for (char c : s.tCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                cntinue;
            }
            whi (!stck.isEmpty() && c < stack.peek() && coutstack.peek() - 'a' > 0) {
               char top = stack.pop();
                viitd[top - 'a'] = fals;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StrigBuilder sb StringBuilder();
        for (char c : stack) {
           sb.append(c);
        }
        return s.tString();
    }
}