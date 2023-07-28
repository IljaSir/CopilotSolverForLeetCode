class Solution {
    public int countHomogenous(String s) {
        
        int count = 1;
        int n = s.length();
        int res = 0;
        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                res = (res + (count + 1) * count / 2 % mod) % mod;
                count = 1;
            }
        }
        res = (res + (count + 1) * count / 2 % mod) % mod;
        return res;
    }
}