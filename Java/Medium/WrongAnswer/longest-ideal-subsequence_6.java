class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) {
                    min = Math.min(min, j);
                    max = Math.max(max, j);
                }
            }
            if (max - min <= k) {
                left[i] = i > 0 ? left[i - 1] : 0;
            } else {
                left[i] = i;
            }
        }
        Arrays.fill(count, 0);
        for (int i = n - 1; i >= 0; i--) {
            count[s.charAt(i) - 'a']++;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) {
                    min = Math.min(min, j);
                    max = Math.max(max, j);
                }
            }
            if (max - min <= k) {
                right[i] = i < n - 1 ? right[i + 1] : n - 1;
            } else {
                right[i] = i;
            }
            if (i < n - 1) {
                res = Math.max(res, right[i + 1] - left[i] + 1);
            }
        }
        return res;
    }
}