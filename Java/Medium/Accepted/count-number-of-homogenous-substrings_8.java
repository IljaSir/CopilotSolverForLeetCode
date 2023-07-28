class Solution {
    public int countHomogenous(String s) {
        
        int count = 0;
        int sum = 0;
        int MOD = 1000000007;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            sum = (sum + count) % MOD;
        }
        return sum;
    }
}