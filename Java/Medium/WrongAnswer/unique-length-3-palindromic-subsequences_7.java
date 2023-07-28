class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int res = 0;
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, s.length());
        for (int i = 0; i < s.length(); i++) {
            left[s.charAt(i) - 'a'] = Math.min(left[s.charAt(i) - 'a'], i);
            right[s.charAt(i) - 'a'] = Math.max(right[s.charAt(i) - 'a'], i);
        }
        for (int i = 0; i < 26; i++) {
            boolean[] seen = new boolean[26];
            for (int j = left[i]; j <= right[i]; j++) {
                if (s.charAt(j) != i + 'a' && !seen[s.charAt(j) - 'a']) {
                    res++;
                    seen[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return res;
    }
}