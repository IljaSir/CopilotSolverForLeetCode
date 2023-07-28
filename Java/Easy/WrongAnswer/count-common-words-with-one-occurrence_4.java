class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        Map<String, Integer> wordCount1 = new HashMap<>();
        Map<String, Integer> wordCount2 = new HashMap<>();
        for (String word : words1) {
            wordCount1.put(word, wordCount1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            wordCount2.put(word, wordCount2.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (String word : wordCount1.keySet()) {
            if (wordCount1.get(word) == 1 && wordCount2.containsKey(word) && wordCount2.get(word) == 1) {
                ans++;
            }
        }
        for (String word : wordCount2.keySet()) {
            if (wordCount2.get(word) == 1 && wordCount1.containsKey(word) && wordCount1.get(word) == 1) {
                ans++;
            }
        }
        return ans;
    }
}