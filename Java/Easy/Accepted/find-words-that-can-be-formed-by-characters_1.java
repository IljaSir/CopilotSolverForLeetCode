class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean good = true;
            for (int i = 0; i < word.length(); i++) {
                if (++wordCount[word.charAt(i) - 'a'] > charCount[word.charAt(i) - 'a']) {
                    good = false;
                    break;
                }
            }
            if (good) {
                sum += word.length();
            }
        }
        return sum;
    }
}