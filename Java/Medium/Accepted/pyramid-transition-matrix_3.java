class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            List<Character> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s.charAt(2));
            map.put(key, list);
        }
        return dfs(bottom, "", 0, map);
    }
    
    private boolean dfs(String bottom, String next, int index, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        if (index == bottom.length() - 1) return dfs(next, "", 0, map);
        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) return false;
        for (char c : map.get(key)) {
            if (dfs(bottom, next + c, index + 1, map)) return true;
        }
        return false;
    }
}