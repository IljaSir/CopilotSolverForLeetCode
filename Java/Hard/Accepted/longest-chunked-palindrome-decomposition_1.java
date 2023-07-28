class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        int res = 0;
        for (int i = 0; i < n / 2; i++) {
            if (text.substring(0, i + 1).equals(text.substring(n - i - 1, n))) {
                res += 2;
                text = text.substring(i + 1, n - i - 1);
                n = text.length();
                i = -1;
            }
        }
        if (n > 0) res++;
        return res;
    }
}