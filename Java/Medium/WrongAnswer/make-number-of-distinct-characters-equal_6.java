class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        int[] cnt = new int[26];
        for (char c : word1.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            cnt[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
            }
        }
        return odd <= 2;
    }
}