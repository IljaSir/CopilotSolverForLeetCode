class Solution {
    public int minSteps(String s, String t) {
        
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(chars[i]);
        }
        return res / 2;
    }
}