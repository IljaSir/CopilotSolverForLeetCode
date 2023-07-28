class Solution {
    public boolean isSolvable(String[] words, String result) {
        
        int[] char2num = new int[26];
        Arrays.fill(char2num, -1);
        int[] char2cnt = new int[26];
        int[] char2cnt2 = new int[26];
        for (String word : words) {
            char2cnt[word.charAt(0) - 'A']++;
        }
        char2cnt[result.charAt(0) - 'A']++;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                char2cnt2[c - 'A']++;
                int num = (int) Math.pow(10, len - j - 1);
                char2num[c - 'A'] = num;
            }
        }
        int len = result.length();
        for (int j = 0; j < len; j++) {
            char c = result.charAt(j);
            char2cnt2[c - 'A']++;
            int num = (int) Math.pow(10, len - j - 1);
            char2num[c - 'A'] = num;
        }
        for (int i = 0; i < 26; i++) {
            if (char2cnt[i] > 1 && char2num[i] == -1) {
                return false;
            }
            if (char2cnt[i] == 1 && char2num[i] == -1) {
                char2num[i] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (char2cnt[i] == 1 && char2cnt2[i] > 1) {
                return false;
            }
        }
        return true;
    }
}