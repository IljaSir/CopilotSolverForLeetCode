class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                a[i] = 1;
            } else {
                b[i] = 1;
            }
            if (locked.charAt(i) == '1') {
                c[i] = 1;
            } else {
                d[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];
            b[i] += b[i - 1];
            c[i] += c[i - 1];
            d[i] += d[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int x = a[i] - (i > 0 ? a[i - 1] : 0);
            int y = b[i] - (i > 0 ? b[i - 1] : 0);
            int z = c[i] - (i > 0 ? c[i - 1] : 0);
            int w = d[i] - (i > 0 ? d[i - 1] : 0);
            if (x >= z && y >= z && x - z <= w && y - z <= w) {
                return true;
            }
        }
        return false;
    }
}