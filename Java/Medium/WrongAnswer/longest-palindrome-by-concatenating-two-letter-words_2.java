class Solution {
    public int longestPalindrome(String[] words) {
        
        int[] count = new int[26 * 26];
        for (String word : words) {
            int x = word.charAt(0) - 'a';
            int y = word.charAt(1) - 'a';
            count[x * 26 + y]++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += count[i * 26 + i] / 2 * 2;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int num = Math.min(count[i * 26 + j], count[j * 26 + i]);
                ans += num * 2;
            }
        }
        return ans < words.length ? ans + 1 : ans;
    }
}