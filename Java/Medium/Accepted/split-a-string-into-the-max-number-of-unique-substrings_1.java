class Solution {
    public int maxUniqueSplit(String s) {
        
        return dfs(s, 0, new HashSet<>());
    }
    
    private int dfs(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return set.size();
        }
        int max = 0;
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            max = Math.max(max, dfs(s, i + 1, set));
            set.remove(sub);
        }
        return max;
    }
}