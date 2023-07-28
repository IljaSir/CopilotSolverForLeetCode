class Solution {
    public int longestDecomposition(String text) {
        
        int res = 0;
        int i = 0, j = text.length() - 1;
        while (i <= j) {
            int k = 0;
            while (text.charAt(i + k) == text.charAt(j - k)) {
                k++;
            }
            if (k == 0) {
                i++;
                j--;
                res += 2;
            } else {
                i += k;
                j -= k;
            }
        }
        return i == j ? res + 1 : res;
    }
}