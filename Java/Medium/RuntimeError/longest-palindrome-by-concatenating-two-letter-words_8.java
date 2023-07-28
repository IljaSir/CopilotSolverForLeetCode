class Solution {
    public int longestPalindrome(String[] words) {
        
        int[] count = new int[52];
        for (String word : words) {
            int mask = 1 << (word.charAt(0) - 'a');
            count[mask]++;
            mask = 1 << (word.charAt(1) - 'a' + 26);
            count[mask]++;
        }
        int res = 0;
        for (int i = 0; i < 52; i++) {
            if (count[i] > 0) {
                res += (count[i] / 2) * 2;
            }
            for (int j = i + 1; j < 52; j++) {
                if (count[i] > 0 && count[j] > 0 && (i & j) == 0) {
                    res += 2;
                }
            }
        }
        return res == words.length ? res : res + 1;
    }
}