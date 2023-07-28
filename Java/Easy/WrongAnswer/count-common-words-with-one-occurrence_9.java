class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        return count(words1, words2) + count(words2, words1);
    }

    private int count(String[] words1, String[] words2) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            if (map.containsKey(word) && map.get(word) == 1) {
                count++;
                map.remove(word);
            }
        }
        return count;
    }
}