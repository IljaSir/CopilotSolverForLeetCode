class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word.length() > 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        Set<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }
        String result = "";
        int max = 0;
        for (String word : map.keySet()) {
            if (!set.contains(word) && map.get(word) > max) {
                max = map.get(word);
                result = word;
            }
        }
        return result;
    }
}