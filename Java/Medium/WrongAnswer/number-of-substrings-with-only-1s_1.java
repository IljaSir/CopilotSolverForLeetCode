class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int result = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                result += (count * (count + 1)) / 2;
                result %= mod;
                count = 0;
            }
        }
        result += (count * (count + 1)) / 2;
        result %= mod;
        return result;
    }
}