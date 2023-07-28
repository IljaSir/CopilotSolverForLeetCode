class Solution {
    public int getMinSwaps(String num, int k) {
        
        char[] c = num.toCharArray();
        while (k-- > 0) {
            nextPermutation(c);
        }
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != num.charAt(i)) {
                int j = i + 1;
                while (c[j] != num.charAt(i)) {
                    j++;
                }
                while (j > i) {
                    swap(c, j, j - 1);
                    j--;
                    res++;
                }
            }
        }
        return res;
    }
    private void nextPermutation(char[] c) {
        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = c.length - 1;
            while (j >= 0 && c[j] <= c[i]) {
                j--;
            }
            swap(c, i, j);
        }
        reverse(c, i + 1, c.length - 1);
    }
    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i, j);
            i++;
            j--;
        }
    }
}