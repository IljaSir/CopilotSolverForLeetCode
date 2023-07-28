class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char c = s.charAt(2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(c);
        }
        return dfs(bottom, map, new StringBuilder(), 0);
    }
    
    private boolean dfs(String bottom, Map<String, List<Character>> map, StringBuilder sb, int idx) {
        if (bottom.length() == 1) return true;
        if (idx == bottom.length() - 1) {
            return dfs(sb.toString(), map, new StringBuilder(), 0);
        }
        String key = bottom.substring(idx, idx + 2);
        List<Character> list = map.getOrDefault(key, new ArrayList<>());
        for (char c : list) {
            sb.append(c);
            if (dfs(bottom, map, sb, idx + 1)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }
}