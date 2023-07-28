class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        int count = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                count++;
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1 && map1.getOrDefault(entry.getKey(), 0) == 1) {
                count++;
            }
        }
        return count;
    }
}