class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String[] words = paragraph.replaceAll("[!?',;.]", " ").toLowerCase().split("\\s+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            if (!bannedSet.contains(w)) {
                count.put(w, count.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}