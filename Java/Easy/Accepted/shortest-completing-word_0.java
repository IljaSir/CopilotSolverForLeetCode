class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] count = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        String res = "";
        for (String word : words) {
            if ((res.length() == 0 || word.length() < res.length()) && contains(count, word)) {
                res = word;
            }
        }
        return res;
    }
    private boolean contains(int[] count, String word) {
        int[] tmp = new int[26];
        for (char c : word.toCharArray()) {
            tmp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (tmp[i] < count[i]) {
                return false;
            }
        }
        return true;
    }
}