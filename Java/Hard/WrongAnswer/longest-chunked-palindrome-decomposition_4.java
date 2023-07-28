class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (text.substring(0, i + 1).equals(text.substring(n - i - 1, n))) {
                count += 2;
                n -= i + 1;
                i = -1;
            }
        }
        return count == 0 ? 1 : count;
    }
}