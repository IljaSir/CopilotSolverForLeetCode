class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] b = new int[n];
        b[n-1] = s.charAt(n-1) == 'b' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            b[i] = b[i+1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int a = 0;
        int res = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                a++;
            }
            res = Math.min(res, a + b[i]);
        }
        return res;
    }
}