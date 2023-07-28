class Solution {
    public int minimumScore(String s, String t) {
        
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.max(0, sCount[i] - tCount[i]);
        }
        return ans;
    }
}