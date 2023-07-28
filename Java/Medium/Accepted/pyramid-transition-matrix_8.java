class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char c = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(c);
        }
        return dfs(bottom, map, "");
    }
    private boolean dfs(String bottom, Map<String, List<Character>> map, String next) {
        if (bottom.length() == 1) {
            return true;
        }
        if (next.length() == bottom.length() - 1) {
            return dfs(next, map, "");
        }
        String key = bottom.substring(next.length(), next.length() + 2);
        if (!map.containsKey(key)) {
            return false;
        }
        for (char c : map.get(key)) {
            if (dfs(bottom, map, next + c)) {
                return true;
            }
        }
        return false;
    }
}