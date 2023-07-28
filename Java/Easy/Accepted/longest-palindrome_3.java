class Solution {
    public int longestPalindrome(String s) {
        
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int res = 0;
        for (int v : count) {
            res += v / 2 * 2;
            if (res % 2 == 0 && v % 2 == 1) {
                res++;
            }
        }
        return res;
    }
}