class Solution {
    public String crackSafe(int n, int k) {
        
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        String start = sb.toString();
        visited.add(start);
        dfs(start, visited, n, k);
        return sb.toString();
    }
    private boolean dfs(String node, HashSet<String> visited, int n, int k) {
        if (visited.size() == Math.pow(k, n)) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            String next = node.substring(1) + i;
            if (!visited.contains(next)) {
                visited.add(next);
                if (dfs(next, visited, n, k)) {
                    return true;
                }
                visited.remove(next);
            }
        }
        return false;
    }
}