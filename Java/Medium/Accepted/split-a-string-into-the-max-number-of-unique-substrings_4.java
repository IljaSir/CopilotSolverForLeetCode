class Solution {
    public int maxUniqueSplit(String s) {
        
        return dfs(s, 0, new HashSet<String>());
    }
    
    private int dfs(String s, int start, HashSet<String> set) {
        if (start == s.length()) {
            return 0;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                res = Math.max(res, 1 + dfs(s, i + 1, set));
                set.remove(sub);
            }
        }
        return res;
    }
}