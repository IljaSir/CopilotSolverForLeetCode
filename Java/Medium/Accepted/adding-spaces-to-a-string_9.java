class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        int n = s.length();
        int m = spaces.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < m; i++) {
            dp[spaces[i]] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (dp[i] == 1) {
                sb.append(' ');
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}