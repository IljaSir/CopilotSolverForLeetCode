class Solution {
    public int longestDecomposition(String text) {
        
        int result = 0;
        int i = 0;
        int j = text.length() - 1;
        while (i <= j) {
            int k = 1;
            while (!text.substring(i, i + k).equals(text.substring(j - k + 1, j + 1))) {
                k++;
            }
            result += 2;
            i += k;
            j -= k;
        }
        if (i == j + 1) {
            result--;
        }
        return result;
    }
}