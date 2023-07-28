class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Set<String> bannedSet = new HashSet();
        for (String word: banned) bannedSet.add(word);
        Map<String, Integer> count = new HashMap();
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");

        for (String word: words) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}