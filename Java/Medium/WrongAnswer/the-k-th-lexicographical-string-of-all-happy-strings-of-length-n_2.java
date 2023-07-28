class Solution {
    public String getHappyString(int n, int k) {
        
        char[] chars = new char[]{'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        return dfs(chars, sb, n, k);
    }
    
    private String dfs(char[] chars, StringBuilder sb, int n, int k) {
        if (sb.length() == n) {
            k--;
            return k == 0 ? sb.toString() : "";
        }
        for (int i = 0; i < chars.length; i++) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != chars[i]) {
                sb.append(chars[i]);
                String res = dfs(chars, sb, n, k);
                if (!"".equals(res)) {
                    return res;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return "";
    }
}