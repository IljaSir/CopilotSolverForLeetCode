class Solution {
    public String crackSafe(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, n, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, Set<String> visited, int n, int k) {
        if (visited.size() == Math.pow(k, n)) {
            return true;
        }
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(sb, visited, n, k)) {
                    return true;
                }
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}