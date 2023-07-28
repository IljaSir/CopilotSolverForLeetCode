class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                if (count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    break;
                }
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }
}