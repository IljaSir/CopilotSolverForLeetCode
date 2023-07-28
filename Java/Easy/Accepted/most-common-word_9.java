class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // 1. Preprocess paragraph
        paragraph = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        // 2. Add words to a hashset
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        // 3. Count frequency
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        // 4. Find the most frequent word
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}