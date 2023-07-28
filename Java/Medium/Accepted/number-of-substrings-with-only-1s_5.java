class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int res = 0;
        int MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count = 0;
            }
            res = (res + count) % MOD;
        }
        return res;
    }
}