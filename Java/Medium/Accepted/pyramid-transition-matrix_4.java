class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom, "", map);
    }
    private boolean dfs(String bottom, String upper, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        if (upper.length() == bottom.length() - 1) return dfs(upper, "", map);
        String key = bottom.substring(upper.length(), upper.length() + 2);
        if (!map.containsKey(key)) return false;
        for (char c : map.get(key)) {
            if (dfs(bottom, upper + c, map)) return true;
        }
        return false;
    }
}