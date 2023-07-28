class Solution {
    public int countHomogenous(String s) {
        
        int mod = 1000000007;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                count = 1;
            } else {
                count++;
            }
            ans = (ans + count) % mod;
        }
        return ans;
    }
}