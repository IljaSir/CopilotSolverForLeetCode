class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int n = s.length();
        int[] count = new int[26];
        int[] used = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (used[c - 'a'] == repeatLimit) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a']--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            used[c - 'a']++;
        }
        return sb.toString();
    }
}