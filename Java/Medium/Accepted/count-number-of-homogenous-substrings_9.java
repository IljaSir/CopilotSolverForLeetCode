class Solution {
    public int countHomogenous(String s) {
        
        int count = 0;
        int mod = 1000000007;
        int ans = 0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                count = 1;
                prev = s.charAt(i);
            }
            ans = (ans + count) % mod;
        }
        return ans;
    }
}