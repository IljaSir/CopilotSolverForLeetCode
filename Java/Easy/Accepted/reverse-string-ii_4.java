class Solution {
    public String reverseStr(String s, int k) {
        
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int j = Math.min(i + k - 1, n - 1);
            swap(c, i, j);
        }
        return new String(c);
    }

    private void swap(char[] c, int i, int j) {
        while (i < j) {
            char t = c[i];
            c[i++] = c[j];
            c[j--] = t;
        }
    }
}