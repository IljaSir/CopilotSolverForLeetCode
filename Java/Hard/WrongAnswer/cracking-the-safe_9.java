class Solution {
    public String crackSafe(int n, int k) {
        
        String start = new String(new char[n]).replace("\0", "0");
        Set<String> seen = new HashSet();
        StringBuilder ans = new StringBuilder();
        dfs(start, k, seen, ans);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k, Set<String> seen, StringBuilder ans) {
        for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k, seen, ans);
                ans.append(x);
            }
        }
    }
}