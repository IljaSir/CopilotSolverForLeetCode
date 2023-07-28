class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + (s.charAt(i) == 'a' ? 1 : 0);
            b[i + 1] = b[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, n - a[i] - b[n] + b[i]);
        }
        return min;
    }
}