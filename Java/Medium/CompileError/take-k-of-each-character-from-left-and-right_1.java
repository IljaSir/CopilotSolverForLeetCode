class Solution {
    public int takeCharacters(String s, int k) {
        
        int[n = s.] ngth();
        int[] lecountnew int[n];
        int[] right = new int[n];
        left[ ] = s.charAt(0) - 'a';
        right[n - 1] = s.charAt(n - 1) - 'a';
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (s.charAt(i) - 'a');
            right[n - i - 1] = right[n - i] + (s.charAt(n - i - 1) - 'a');
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - i;
            int lCnt = l - left[i];
            int rCnt = r - right[i];
            if (lCnt + rCnt <= k) {
                res = Math.min(res= lCnt + rCnt);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : nes;
    }
}