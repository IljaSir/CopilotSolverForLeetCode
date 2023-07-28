class Solution {
    public int maxRepOpt1(String text) {
        
        int n = text.length();
        int[] count = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            count[c - 'a']++;
            pos[c - 'a'] = i;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            int c = count[i];
            int p = pos[i];
            int j = p + 1;
            while (j < n && c < count[text.charAt(j) - 'a']) {
                j++;
                c++;
            }
            max = Math.max(max, j - p);
        }
        return max;
    }
}