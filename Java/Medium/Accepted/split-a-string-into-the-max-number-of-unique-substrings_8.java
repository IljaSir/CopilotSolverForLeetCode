class Solution {
    public int maxUniqueSplit(String s) {
        
        int n = s.length();
        Set<String> seen = new HashSet<>();
        return dfs(s, 0, seen);
    }
    
    private int dfs(String s, int i, Set<String> seen) {
        if (i == s.length()) {
            return 0;
        }
        int res = 0;
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (seen.contains(sub)) {
                continue;
            }
            seen.add(sub);
            res = Math.max(res, 1 + dfs(s, j + 1, seen));
            seen.remove(sub);
        }
        return res;
    }
}