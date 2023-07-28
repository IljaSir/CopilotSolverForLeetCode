class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (text.substring(0, i + 1).equals(text.substring(n - i - 1))) {
                ans += 2;
                n -= i + 1;
                i = -1;
            }
        }
        return ans + (n > 0 ? 1 : 0);
    }
}