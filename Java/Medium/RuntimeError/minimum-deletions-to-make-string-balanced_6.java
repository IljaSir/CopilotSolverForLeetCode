class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
            a[i] = count;
        }
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                count++;
            }
            b[i] = count;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i] + b[i + 1]);
        }
        return min;
    }
}