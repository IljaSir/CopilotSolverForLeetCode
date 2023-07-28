class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a'] == 0) {
                r++;
            }
            right[c - 'a']++;
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
            right[c - 'a']--;
            if (left[c - 'a'] == 1) {
                l++;
            }
            if (right[c - 'a'] == 0) {
                r--;
            }
            if (l == r) {
                res++;
            }
        }
        return res;
    }
}