class Solution {
    public int longestPalindrome(String[] words) {
        
        int res = 0;
        int[] count = new int[52];
        for (String word : words) {
            int mask = 1 << (word.charAt(0) - 'a');
            mask |= 1 << (word.charAt(1) - 'a' + 26);
            count[mask]++;
        }
        for (int i = 0; i < 52; i++) {
            for (int j = i; j < 52; j++) {
                if ((i & j) == 0) {
                    res += count[i] * count[j];
                }
            }
        }
        res += count[0] * (count[0] - 1) / 2;
        return res;
    }
}