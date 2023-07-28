class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        if (n == 0) {
            return 0;
        }
        int mid = n / 2;
        String s1 = text.substring(0, mid);
        String s2 = text.substring(n - mid, n);
        if (s1.equals(s2)) {
            return 2 + longestDecomposition(text.substring(mid, n - mid));
        } else {
            return 1;
        }
    }
}