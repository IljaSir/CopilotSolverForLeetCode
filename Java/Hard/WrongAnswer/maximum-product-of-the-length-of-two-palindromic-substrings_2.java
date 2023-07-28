class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        long ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                left[i] = r - l + 1;
                l--;
                r++;
            }
        }
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                right[i] = r - l + 1;
                l--;
                r++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (left[i] > 0 && right[j] > 0) {
                    ans = Math.max(ans, left[i] * right[j]);
                }
                if (right[i] > 0 && left[j] > 0) {
                    ans = Math.max(ans, right[i] * left[j]);
                }
            }
        }
        return ans;
    }
}