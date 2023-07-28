class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ew ArrayList<>();
        int n = s.length();
        if (n < 10) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}