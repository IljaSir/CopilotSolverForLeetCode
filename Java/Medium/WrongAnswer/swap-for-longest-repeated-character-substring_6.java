class Solution {
    public int maxRepOpt1(String text) {
        
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[i] = -1;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            if (index[c] == -1) {
                index[c] = i;
            } else {
                if (i - index[c] == count[c]) {
                    cur--;
                }
            }
            cur++;
            max = Math.max(max, cur);
            if (i == text.length() - 1 || text.charAt(i) != text.charAt(i + 1)) {
                if (count[c] > 1) {
                    if (i - index[c] + 1 == count[c]) {
                        cur--;
                    }
                    cur++;
                    max = Math.max(max, cur);
                }
                cur = 0;
                for (int j = 0; j < 26; j++) {
                    index[j] = -1;
                }
            }
        }
        return max;
    }
}