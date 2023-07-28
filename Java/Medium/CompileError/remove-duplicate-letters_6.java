class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] seen = new boo
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }nt[26];
        boolea[] visied = new boolean
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : s;
        }
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]--;
            if (visited[index]) {
                continuetack) {
                sb.append(c);
            while (!stack.isEmpty() && stack.peek() > index && count[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }
            stack.push(index);
            visited[index] = true;
        }
        }ringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append((char) ('a' + stack.pop()));
        }
        return sb.reverse().toString();
    }
}