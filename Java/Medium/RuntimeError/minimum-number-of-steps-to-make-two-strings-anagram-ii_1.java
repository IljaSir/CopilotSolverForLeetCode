class Solution {
    public int minSteps(String s, String t) {
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        int ans = 0;
        for (int f : freq)
            ans += Math.max(0, f);
        return ans;
    }
}