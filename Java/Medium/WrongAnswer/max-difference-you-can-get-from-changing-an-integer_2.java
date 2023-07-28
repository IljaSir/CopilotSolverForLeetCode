class Solution {
    public int maxDiff(int num) {
        
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int[] a = new int[s.length()];
        int[] b = new int[s.length()];
        int[] c1 = new int[s.length()];
        int[] c2 = new int[s.length()];
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        for (char cc : c) {
            int n = cc - '0';
            if (n == 9) {
                a[i++] = n;
                b[j++] = n;
            } else if (n == 1) {
                a[i++] = n;
                b[j++] = n;
            } else {
                a[i++] = 9;
                b[j++] = 1;
                x = n;
                y = n;
            }
        }
        i = 0;
        j = 0;
        for (char cc : c) {
            int n = cc - '0';
            if (n == x) {
                c1[i++] = y;
                c2[j++] = 9;
            } else if (n == y) {
                c1[i++] = x;
                c2[j++] = 1;
            } else {
                c1[i++] = n;
                c2[j++] = n;
            }
        }
        int aa = 0;
        for (int m : a) {
            aa = aa * 10 + m;
        }
        int bb = 0;
        for (int m : b) {
            bb = bb * 10 + m;
        }
        int cc1 = 0;
        for (int m : c1) {
            cc1 = cc1 * 10 + m;
        }
        int cc2 = 0;
        for (int m : c2) {
            cc2 = cc2 * 10 + m;
        }
        return Math.max(Math.abs(aa - bb), Math.abs(cc1 - cc2));
    }
}