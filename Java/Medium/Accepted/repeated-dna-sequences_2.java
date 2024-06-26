class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }
}