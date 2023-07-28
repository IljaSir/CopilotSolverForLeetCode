class Solution {
    public String digitSum(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
            dp[i] = sum % 9 == 0 ? 9 : (sum % 9);
            if (i >= k)
                sum -= s.charAt(i - k) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dp[i]);
            if (sb.length() == k)
                break;
        }
        return sb.toString();
    }
}