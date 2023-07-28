class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]--;
            if (visited[index]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > index && count[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }
            stack.push(index);
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}