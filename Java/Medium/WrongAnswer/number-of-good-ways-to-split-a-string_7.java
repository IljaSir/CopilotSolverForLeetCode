class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
            right[c - 'a']--;
            if (right[c - 'a'] == 0) {
                count++;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (left[i] > 0) {
                res++;
            }
            if (right[i] > 0) {
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        return res;
    }
}