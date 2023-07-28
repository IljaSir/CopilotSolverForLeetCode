class Solution {
    public int numSub(String s) {
        
        long count = 0;
        long res = 0;
        int mod = 1000000007;
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
        return (int)res;
    }
}