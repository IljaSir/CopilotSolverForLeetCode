class Solution {
    public int distinctSubseqII(String s) {
        
        int mod = 1000000007;
        int[] count = new int[26];
        int sum = 0;
        for (char c : s.toCharArray()) {
            int prev = sum;
            sum = (sum * 2 + 1) % mod;
            sum = (sum - count[c - 'a'] + mod) % mod;
            count[c - 'a'] = prev;
        }
        return sum;
    }
}