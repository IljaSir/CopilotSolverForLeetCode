class Solution {
    public int maxRepOpt1(String text) {
        
        int[] counts = new int[26];
        int[] ends = new int[26];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
            ends[text.charAt(i) - 'a'] = i;
        }
        int max = 0;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            int j = i + 1;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            max = Math.max(max, Math.min(counts[c], j - i + 1));
            if (j < text.length()) {
                int nc = text.charAt(j) - 'a';
                if (counts[nc] + counts[c] >= j - i + 1) {
                    max = Math.max(max, j - i + 1);
                }
            }
            i = j - 1;
        }
        return max;
    }
}