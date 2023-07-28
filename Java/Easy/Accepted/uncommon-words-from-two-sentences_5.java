class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        Map<String, Integer> s1Map = new HashMap<>();
        Map<String, Integer> s2Map = new HashMap<>();
        for (String s : s1s) {
            s1Map.put(s, s1Map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2s) {
            s2Map.put(s, s2Map.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String s : s1Map.keySet()) {
            if (s1Map.get(s) == 1 && !s2Map.containsKey(s)) {
                result.add(s);
            }
        }
        for (String s : s2Map.keySet()) {
            if (s2Map.get(s) == 1 && !s1Map.containsKey(s)) {
                result.add(s);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}