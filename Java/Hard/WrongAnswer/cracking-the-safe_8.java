class Solution {
    public String crackSafe(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> set = new HashSet<>();
        set.add(sb.toString());
        int total = (int) Math.pow(k, n);
        dfs(sb, set, total, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, Set<String> set, int total, int k) {
        if (set.size() == total) {
            return true;
        }
        String prev = sb.substring(sb.length() - (sb.length() - sb.length() / k * k));
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!set.contains(next)) {
                set.add(next);
                sb.append(i);
                if (dfs(sb, set, total, k)) {
                    return true;
                }
                set.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}