class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.add(words[i]);
                continue;
            }
            String currentWord = words[i];
            boolean isAnagram = false;
            for (int j = 0; j < result.size(); j++) {
                String currentResultWord = result.get(j);
                if (currentResultWord.length() != currentWord.length()) {
                    continue;
                }
                if (isAnagram(currentResultWord, currentWord)) {
                    isAnagram = true;
                    break;
                }
            }
            if (!isAnagram) {
                result.add(currentWord);
            }
        }
        return result;
    }
    
    public boolean isAnagram(String word1, String word2) {
        int[] charCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charCount[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            charCount[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
}