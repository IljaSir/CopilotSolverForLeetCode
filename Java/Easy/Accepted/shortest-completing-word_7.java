class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        String license = licensePlate.toLowerCase();
        int[] charCnt = new int[26];
        for (int i = 0; i < license.length(); i++) {
            char c = license.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charCnt[c - 'a']++;
            }
        }
        String ans = "";
        for (String word : words) {
            if (word.length() < ans.length() || ans.length() == 0) {
                int[] cnt = new int[26];
                for (int i = 0; i < word.length(); i++) {
                    cnt[word.charAt(i) - 'a']++;
                }
                boolean ok = true;
                for (int i = 0; i < 26; i++) {
                    if (charCnt[i] > cnt[i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}