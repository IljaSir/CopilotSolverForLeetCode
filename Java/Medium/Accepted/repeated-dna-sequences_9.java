class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10) return ans;
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 9; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) ans.add(entry.getKey());
        }
        return ans;
    }
}