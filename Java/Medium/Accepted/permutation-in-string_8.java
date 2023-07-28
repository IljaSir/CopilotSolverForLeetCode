class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < m; ++i) {
            if (cnt[s2.charAt(i) - 'a']-- > 0) {
                n--;
            }
            if (i >= s1.length() && cnt[s2.charAt(i - s1.length()) - 'a']++ >= 0) {
                n++;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}