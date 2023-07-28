class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int res = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                res += (count * (count + 1)) / 2;
                count = 0;
            }
        }
        if (count > 0) {
            res += (count * (count + 1)) / 2;
        }
        return res % mod;
    }
}