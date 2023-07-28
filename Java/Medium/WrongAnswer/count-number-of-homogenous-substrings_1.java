class Solution {
    public int countHomogenous(String s) {
        
        int count = 1;
        int sum = 0;
        int mod = 1000000007;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sum = (sum + count * (count + 1) / 2) % mod;
                count = 1;
            }
        }
        sum = (sum + count * (count + 1) / 2) % mod;
        return sum;
    }
}