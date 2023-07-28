class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        int i = 0, j = n - 1;
        int res = 0;
        while (i <= j) {
            if (text.charAt(i) == text.charAt(j)) {
                int k = 0;
                while (i + k <= j - k && text.charAt(i + k) == text.charAt(j - k)) {
                    k++;
                }
                if (i + k > j - k) {
                    res += i == j ? 1 : 2;
                }
                i += k;
                j -= k;
            } else {
                i++;
                j--;
                res++;
            }
        }
        return res;
    }
}