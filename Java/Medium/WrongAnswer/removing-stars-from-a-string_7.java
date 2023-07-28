class Solution {
    public String removeStars(String s) {
        
        int[] a = new int[s.length()];
        int[] b = new int[s.length()];
        int m = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                a[m++] = i;
            } else {
                b[n++] = i;
            }
        }
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (j < m && b[i] > a[j]) {
                j++;
            }
            if (j == m || b[i] < a[j]) {
                sb.append(s.charAt(b[i]));
            }
        }
        return sb.toString();
    }
}