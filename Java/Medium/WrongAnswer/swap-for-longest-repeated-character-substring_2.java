class Solution {
    public int maxRepOpt1(String text) {
        
        int[] count = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
            last[text.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            int j = i;
            while (j < text.length() && (text.charAt(j) == text.charAt(i) || count[text.charAt(j) - 'a'] < 2)) {
                j++;
            }
            res = Math.max(res, j - i);
            if (j < text.length() && count[text.charAt(j) - 'a'] >= 2 && last[text.charAt(j) - 'a'] >= j) {
                res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}