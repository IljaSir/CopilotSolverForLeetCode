class Solution {
    public int maxRepOpt1(String text) {
        
        int[] count = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
            last[text.charAt(i) - 'a'] = i;
        }
        int max = 0;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            int j = i;
            while (j < text.length() && (text.charAt(j) - 'a' == c || count[c] > 1)) {
                if (text.charAt(j) - 'a' != c) {
                    count[c]--;
                }
                j++;
            }
            max = Math.max(max, j - i);
            count[c] = last[c] - i + 1;
        }
        return max;
    }
}