class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int ans = 0, count = 0, max = 0;
        char prev = 'a';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= prev) {
                count++;
                if (c != prev) {
                    max = 1;
                    prev = c;
                } else {
                    max++;
                }
            } else {
                if (c == 'a' && max == 5) {
                    ans = Math.max(ans, count);
                }
                count = 1;
                max = 1;
                prev = c;
            }
        }
        if (max == 5) {
            ans = Math.max(ans, count);
        }
        return ans;
    }
}