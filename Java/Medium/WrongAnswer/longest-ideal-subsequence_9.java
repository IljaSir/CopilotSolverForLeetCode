class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[26];
        int[] max = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            max[c] = Math.max(max[c], count[c]);
            if (i - max[c] >= k) {
                res = Math.max(res, i - left[i - 1] + 1);
            }
            left[i] = i - count[c] + 1;
        }
        Arrays.fill(count, 0);
        Arrays.fill(max, 0);
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            max[c] = Math.max(max[c], count[c]);
            if (i + max[c] <= n - k - 1) {
                res = Math.max(res, right[i + 1] - i + 1);
            }
            right[i] = i + count[c] - 1;
        }
        return res;
    }
}