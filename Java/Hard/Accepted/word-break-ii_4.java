class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            dfs(s, res, new ArrayList<>(), 0, set);
        }
        return res;
    }

    private void dfs(String s, List<String> res, List<String> path, int idx, Set<String> set) {
        if (idx == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (set.contains(sub)) {
                path.add(sub);
                dfs(s, res, path, i, set);
                path.remove(path.size() - 1);
            }
        }
    }
}