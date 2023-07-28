class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[n * 2];
        for (int i = 0; i < n; i++) {
            a[i] = a[i + n] = s.charAt(i) - '0';
        }
        int[] b = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            b[i] = i % 2;
        }
        int[] c = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            c[i] = 1 - i % 2;
        }
        int ans = Integer.MAX_VALUE;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                x++;
            }
            if (a[i] != c[i]) {
                y++;
            }
        }
        ans = Math.min(ans, x);
        ans = Math.min(ans, y);
        for (int i = n; i < n * 2; i++) {
            if (a[i - n] != b[i - n]) {
                x--;
            }
            if (a[i - n] != c[i - n]) {
                y--;
            }
            if (a[i] != b[i]) {
                x++;
            }
            if (a[i] != c[i]) {
                y++;
            }
            ans = Math.min(ans, x);
            ans = Math.min(ans, y);
        }
        return ans;
    }
}