class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        String ans = "";
        for (int i = 0; i < 2*n - 1; ++i) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }
        }
        return ans;
    }
}