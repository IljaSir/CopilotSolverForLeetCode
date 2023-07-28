class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == 0) {
                first[c] = i + 1;
            }
            last[c] = i + 1;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == 0) {
                continue;
            }
            int[] count = new int[26];
            for (int j = first[i]; j < last[i]; j++) {
                count[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) {
                    res++;
                }
            }
        }
        return res;
    }
}