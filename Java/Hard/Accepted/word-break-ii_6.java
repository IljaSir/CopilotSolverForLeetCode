class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return find(s, dict, map);
    }
    private List<String> find(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (dict.contains(s)) {
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (dict.contains(right)) {
                String left = s.substring(0, i);
                List<String> lefts = find(left, dict, map);
                for (String l : lefts) {
                    result.add(l + " " + right);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}