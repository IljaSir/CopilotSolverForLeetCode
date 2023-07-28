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
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}