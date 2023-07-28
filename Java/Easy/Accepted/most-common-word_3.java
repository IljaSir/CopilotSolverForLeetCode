class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        Set<String> bannedWords = new HashSet<String>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word: words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}