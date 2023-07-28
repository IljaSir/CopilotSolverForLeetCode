class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int mod = 1_000_000_007;
        int end0 = 0, end1 = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                end0 = (end0 + end1) % mod;
            } else {
                end1 = (end0 + end1 + 1) % mod;
            }
        }
        return (end0 + end1 + (binary.indexOf('0') == -1 ? 1 : 0)) % mod;
    }
}