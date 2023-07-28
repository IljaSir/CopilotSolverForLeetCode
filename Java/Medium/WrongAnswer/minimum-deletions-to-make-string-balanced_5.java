class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] b = new int[n];
        b[n-1] = s.charAt(n-1) == 'b' ? 1 : 0;
        for (int i = n-2; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                b[i] = b[i+1] + 1;
            } else {
                b[i] = b[i+1];
            }
        }
        int a = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, a + b[i]);
            if (s.charAt(i) == 'a') {
                a++;
            }
        }
        return ans;
    }
}