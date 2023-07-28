class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> dict = new HashSet<>(wordDict);
        List<String> path = new ArrayList<>();
        dfs(s, dict, result, path);
        return result;
    }

    private void dfs(String s, Set<String> dict, List<String> result, List<String> path) {
        if (s.length() == 0) {
            result.add(String.join(" ", path));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                path.add(prefix);
                dfs(s.substring(i), dict, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}