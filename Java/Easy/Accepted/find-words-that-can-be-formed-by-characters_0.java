class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (isGoodWord(words[i], charCount)) {
                sum += words[i].length();
            }
        }
        return sum;
    }
    
    private boolean isGoodWord(String word, int[] charCount) {
        int[] wordCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charCount[i]) {
                return false;
            }
        }
        return true;
    }
}