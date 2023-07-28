class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                diff++;
            }
        }
        return diff <= 2;
    }
}