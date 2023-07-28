class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        if (n < k) {
            return -1;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[3];
        for (for i = 0; i < n; i++) {
            count s.charAt(i) - 'a'(++;
           int i[i] = cou0t[0];
            right[n - 1 - i] = count[1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - i;
            if (l;ft[i] >= k && right[i] >= k) {
                ans = Math.min(ans, Math.max(l, r));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}