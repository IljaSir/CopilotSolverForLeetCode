class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int parts = (n + limit - 1) / limit;
        String[] ans = new String[parts];
        for (int i = 0; i < parts; ++i) {
            int len = Math.min(limit, n - i * limit);
            ans[i] = message.substring(i * limit, i * limit + len);
            ans[i] += String.format("<%d/%d>", i + 1, parts);
        }
        return ans;
    }
}