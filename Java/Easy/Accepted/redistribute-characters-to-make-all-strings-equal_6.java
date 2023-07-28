class Solution {
    public boolean makeEqual(String[] words) {
        
        int[] letterCount = new int[26];
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                letterCount[word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < letterCount.length; i++) {
            if (letterCount[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}