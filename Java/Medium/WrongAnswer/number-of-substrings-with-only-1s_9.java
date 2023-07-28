class Solution {
    public int numSub(String s) {
        
        int mod = (int) (1e9 + 7);
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                res += (count * (count + 1)) / 2;
                res %= mod;
                count = 0;
            }
        }
        res += (count * (count + 1)) / 2;
        res %= mod;
        return res;
    }
}