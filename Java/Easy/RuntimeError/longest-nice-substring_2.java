class Solution {
    public String longestNiceSubstring(String s) {
        
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (j - i > ans.length() && isNice(s.substring(i, j))) {
                    ans = s.substring(i, j);
                }
            }
        }
        return ans;
    }
    
    private boolean isNice(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0 && cnt[i ^ 1 << 5] == 0) {
                return false;
            }
        }
        return true;
    }
}