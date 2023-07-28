class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            int cnt = (j - i + 1) / k;
            if (cnt > 0) {
                ans += String.valueOf(s.charAt(i)).repeat(cnt);
            }
            i = j;
        }
        return ans;
    }
}