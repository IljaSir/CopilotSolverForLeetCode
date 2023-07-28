class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (l[idx] == -1) l[idx] = i;
            r[idx] = i;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = l[s.charAt(0) - 'a'];
        for (int i = 1; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (idx - s.charAt(i - 1) <= k) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }
        right[n - 1] = r[s.charAt(n - 1) - 'a'];
        for (int i = n - 2; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (s.charAt(i + 1) - idx <= k) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, right[i] - left[i] + 1);
        }
        return res;
    }
}