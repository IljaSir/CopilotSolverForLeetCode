class Solution {
    public int minSteps(String s, String t) {
        
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.max(0, tChars[i] - sChars[i]);
        }
        return diff;
    }
}