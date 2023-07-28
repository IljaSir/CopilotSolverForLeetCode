class Solution {
    public String crackSafe(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        int total = (int) Math.pow(k, n);
        dfs(sb, visited, total, n, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, Set<String> visited, int total, int n, int k) {
        if (visited.size() == total) {
            return true;
        }
        String pre = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String cur = pre + i;
            if (!visited.contains(cur)) {
                visited.add(cur);
                sb.append(i);
                if (dfs(sb, visited, total, n, k)) {
                    return true;
                }
                visited.remove(cur);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}