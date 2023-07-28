class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = s.charAt(i % n) - '0';
        }
        int[] b = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            b[i] = a[i] ^ (i % 2);
        }
        int ans = n;
        for (int i = 0; i < 2 * n; i++) {
            int c = 0;
            for (int j = i; j < i + n; j++) {
                if (a[j] != b[j]) {
                    c++;
                }
            }
            ans = Math.min(ans, c);
        }
        return ans;
    }
}