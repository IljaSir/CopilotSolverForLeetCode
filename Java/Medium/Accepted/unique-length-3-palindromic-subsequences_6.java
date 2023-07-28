class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int n = s.length();
        Arrays.fill(left, n);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }
        int res = 0;
        for (int c = 0; c < 26; c++) {
            if (left[c] < right[c]) {
                boolean[] seen = new boolean[26];
                for (int i = left[c] + 1; i < right[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                for (int i = 0; i < 26; i++) {
                    if (seen[i]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}