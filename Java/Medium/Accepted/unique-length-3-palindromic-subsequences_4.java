class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            first[c - 'a'] = Math.min(first[c - 'a'], i);
            last[c - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            int f = first[i];
            int l = last[i];
            if (f == Integer.MAX_VALUE || l == Integer.MIN_VALUE || f == l) continue;
            int[] count = new int[26];
            for (int j = f + 1; j < l; j++) {
                count[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) res++;
            }
        }
        return res;
    }
}