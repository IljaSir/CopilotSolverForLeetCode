class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] start = new int[26];
        int[] end = new int[26];
        for (int i = 0; i < 26; i++) {
            start[i] = s.length();
            end[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            start[c] = Math.min(start[c], i);
            end[c] = Math.max(end[c], i);
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            dp[i] = end[c];
        }
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Math.min(dp[i], dp[i - 1]);
        }
        List<String> res = new ArrayList<>();
        int lastStart = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (start[c] == i) {
                if (dp[end[c]] >= i) {
                    res.add(s.substring(i, end[c] + 1));
                    lastStart = end[c] + 1;
                }
            }
        }
        return res;
    }
}