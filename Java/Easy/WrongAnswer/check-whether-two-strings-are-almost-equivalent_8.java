class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
        if(word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for(int i = 0; i < 26; i++) {
            diff += Math.abs(count1[i] - count2[i]);
            if(diff > 3) {
                return false;
            }
        }
        return true;
    }
}