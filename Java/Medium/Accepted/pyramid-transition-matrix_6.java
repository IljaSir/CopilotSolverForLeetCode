class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(s.substring(2));
        }
        return helper(bottom, "", map);
    }
    
    private boolean helper(String bottom, String upper, Map<String, List<String>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        if (upper.length() == bottom.length() - 1) {
            return helper(upper, "", map);
        }
        String key = bottom.substring(upper.length(), upper.length() + 2);
        if (!map.containsKey(key)) {
            return false;
        }
        for (String s : map.get(key)) {
            if (helper(bottom, upper + s, map)) {
                return true;
            }
        }
        return false;
    }
}