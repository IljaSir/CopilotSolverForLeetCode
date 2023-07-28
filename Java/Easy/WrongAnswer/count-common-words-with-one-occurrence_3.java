class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                res++;
            }
        }
        return res;
    }
}