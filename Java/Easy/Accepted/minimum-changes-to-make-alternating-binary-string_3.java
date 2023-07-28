class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i % 2;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = (i + 1) % 2;
        }
        return Math.min(count(a, b), count(a, c));
    }
    
    private int count(int[] a, int[] b) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] == b[i] ? 0 : 1;
        }
        return ans;
    }
}