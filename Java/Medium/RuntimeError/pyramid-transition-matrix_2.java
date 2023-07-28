class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            Set<Character> set = map.getOrDefault(key, new HashSet<>());
            set.add(s.charAt(2));
            map.put(key, set);
        }
        return dfs(bottom, "", map);
    }
    
    private boolean dfs(String bottom, String next, Map<String, Set<Character>> map) {
        if (bottom.length() == 1 && next.length() == 1) return true;
        if (bottom.length() == next.length()) return dfs(next, "", map);
        
        int i = next.length();
        String key = bottom.substring(i, i + 2);
        if (!map.containsKey(key)) return false;
        for (Character c : map.get(key)) {
            if (dfs(bottom, next + c, map)) return true;
        }
        return false;
    }
}