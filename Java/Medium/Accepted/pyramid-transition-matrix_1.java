class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.substring(2));
        }
        return dfs(bottom, "", map);
    }
    private boolean dfs(String bottom, String up, Map<String, List<String>> map) {
        if (bottom.length() == 1) return true;
        if (up.length() == bottom.length() - 1) return dfs(up, "", map);
        String key = bottom.substring(up.length(), up.length() + 2);
        if (!map.containsKey(key)) return false;
        for (String s : map.get(key)) {
            if (dfs(bottom, up + s, map)) return true;
        }
        return false;
    }
}