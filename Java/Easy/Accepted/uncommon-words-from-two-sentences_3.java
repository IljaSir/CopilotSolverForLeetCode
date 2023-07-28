class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String w : words1) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String w : map.keySet()) {
            if (map.get(w) == 1) {
                result.add(w);
            }
        }
        String[] array = new String[result.size()];
        return result.toArray(array);
    }
}