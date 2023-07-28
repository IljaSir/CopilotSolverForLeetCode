class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int[] count = new int[26];
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < word.length() && j < word.length()) {
            if (j == 0 || word.charAt(j) >= word.charAt(j - 1)) {
                count[word.charAt(j) - 'a']++;
                j++;
            } else {
                i = j;
                count = new int[26];
            }
            if (count['a' - 'a'] >= 1 && count['e' - 'a'] >= 1 && count['i' - 'a'] >= 1 && count['o' - 'a'] >= 1 && count['u' - 'a'] >= 1) {
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}