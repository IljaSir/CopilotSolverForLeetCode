class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!seen[c - 'a']) {
                while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    seen[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                seen[c - 'a'] = true;
                sb.append(c);
            }
            count[c - 'a']--;
        }
        return sb.toString();
    }
}