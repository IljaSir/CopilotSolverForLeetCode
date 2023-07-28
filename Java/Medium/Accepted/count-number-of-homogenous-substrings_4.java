class Solution {
    public int countHomogenous(String s) {
        
        int count = 1;
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            sum = (sum + count) % mod;
        }
        return sum;
    }
}