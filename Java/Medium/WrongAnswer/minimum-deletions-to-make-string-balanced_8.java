class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] b = new int[n];
        int[] a = new int[n];
        if (s.charAt(n - 1) == 'b') {
            b[n - 1] = 1;
        }
        if (s.charAt(n - 1) == 'a') {
            a[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            b[i] = b[i + 1];
            a[i] = a[i + 1];
            if (s.charAt(i) == 'b') {
                b[i]++;
            }
            if (s.charAt(i) == 'a') {
                a[i]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(a[i] + b[i], min);
        }
        return min;
    }
}