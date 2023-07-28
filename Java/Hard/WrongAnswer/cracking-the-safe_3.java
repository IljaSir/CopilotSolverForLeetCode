class Solution {
    public String crackSafe(int n, int k) {
        
        if (n == 1 && k == 1) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            sb.append("0");
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, n, k);
        return sb.toString();
    }
    
    private void dfs(StringBuilder sb, Set<String> visited, int n, int k) {
        if (visited.size() == Math.pow(k, n)) {
            return;
        }
        String prev = sb.substring(sb.length()-n+1);
        for (char c = '0'; c < '0'+k; c++) {
            String next = prev + c;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(c);
                dfs(sb, visited, n, k);
            }
        }
    }
}