class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Set<String> bannedWords = new HashSet<String>();
        for (String word : banned) {
            bannedWords.add(word);
        }
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        int maxCount = 0;
        String maxWord = "";
        for (String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                if (wordCount.get(word) > maxCount) {
                    maxCount = wordCount.get(word);
                    maxWord = word;
                }
            }
        }
        return maxWord;
    }
}