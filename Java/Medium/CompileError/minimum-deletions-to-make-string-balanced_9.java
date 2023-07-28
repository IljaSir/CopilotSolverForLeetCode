class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] ab = new int[n];
        int[] ba = new int[n];
        int[] abba = new int[n];
        a[0] = s.charAt(0) == 'a' ? 1 : 0;
        b[0] = s.charAt(0) == 'b' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
            b[i] = b[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'a') {
                ab[i] = ab[i - 1];
                if (s.charAt(i - 1) == 'b') {
                    ab[i] = Math.max(ab[i], b[i - 1]);
                }
            } else {
                ab[i] = ab[i - 1];
                if (s.charAt(i - 1) == 'a') {
                    ab[i] = Math.max(ab[i], a[i - 1]);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                ba[i] = ba[i + 1];
                if (s.charAt(i + 1) == 'b') {
                    ba[i] = Math.max(ba[i], b[i + 1]);
                }
            } else {
                ba[i] = ba[i + 1];
                if (s.charAt(i + 1) == 'a') {
                    ba[i] = Math.max(ba[i], a[i + 1]);
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == 'a') {
                abba[i] = ab[i - 1] + ba[i + 1];
                if (s.charAt(i - 1) == 'b') {
                    abba[i] = Math.max(abba
    }
}