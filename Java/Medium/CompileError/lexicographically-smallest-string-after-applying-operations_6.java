class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(p[i]) > s.charAt(p[j])) {
                    int t = p[i];
                    p[i] = p[j];
                    p[j] = t;
                }
            }
        }
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = (i + b) % n;
        }
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = (s.charAt(i) - '0' + a * (i & 1)) % 10;
        }
        String ans = s;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        do {
            char[] t = new char[n];
            for (int i = 0; i < n; i++) {
                t[i] = (char) (r[perm[i]] + '0');
            }
            for (int i = 0; i < n; i++) {
                t[q[i]] = t[i];
            }
            String cur = new String(t);
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
        } while (nextPermutation(perm));
        return ans;
    }

    private boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = n - 1;
        while (a[j] <= a[i - 1]) {
            j--;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        j = n - 1
    }
}