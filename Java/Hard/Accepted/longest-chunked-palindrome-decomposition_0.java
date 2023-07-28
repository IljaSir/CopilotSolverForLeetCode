class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        for (int i = 1; i <= n / 2; i++) {
            if (text.substring(0, i).equals(text.substring(n - i, n))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return n > 0 ? 1 : 0;
    }
}