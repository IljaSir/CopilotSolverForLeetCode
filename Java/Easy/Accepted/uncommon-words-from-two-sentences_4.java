class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<String>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}