class Solution {
    public int maxUniqueSplit(String s) {
        
        return dfs(s, 0, new HashSet<>());
    }
    
    private int dfs(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int max = 0;
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1);
            if (!seen.contains(curr)) {
                seen.add(curr);
                max = Math.max(max, 1 + dfs(s, i + 1, seen));
                seen.remove(curr);
            }
        }
        return max;
    }
}