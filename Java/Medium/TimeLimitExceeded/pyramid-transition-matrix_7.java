class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s: allowed) {
            String key = s.substring(0, 2);
            char c = s.charAt(2);
            map.putIfAbsent(key, new HashSet<>());
            map.get(key).add(c);
        }
        return dfs(bottom, "", map);
    }
    
    private boolean dfs(String bottom, String up, Map<String, Set<Character>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        if (up.length() == bottom.length() - 1) {
            return dfs(up, "", map);
        }
        int i = up.length();
        String key = bottom.substring(i, i + 2);
        if (!map.containsKey(key)) {
            return false;
        }
        for (char c: map.get(key)) {
            if (dfs(bottom, up + c, map)) {
                return true;
            }
        }
        return false;
    }
}