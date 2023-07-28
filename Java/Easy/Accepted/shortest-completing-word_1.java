class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] count = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        String res = "aaaaaaaaaaaaaaa";
        for (String word : words) {
            if (word.length() < res.length() && match(word, count)) {
                res = word;
            }
        }
        return res;
    }
    
    private boolean match(String word, int[] count) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > cnt[i]) {
                return false;
            }
        }
        return true;
    }
}