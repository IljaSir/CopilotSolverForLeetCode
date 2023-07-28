class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                sum += count * (count + 1) / 2;
                sum %= mod;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        sum %= mod;
        return sum;
    }
}