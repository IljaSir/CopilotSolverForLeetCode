class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int n = message.length();
        int p = (n + limit - 1) / limit;
        String[] ans = new String[p];
        int i = 0;
        for (int j = 0; j < p; ++j) {
            ans[j] = message.substring(i, Math.min(i + limit, n));
            ans[j] += String.format("<%d/%d>", j + 1, p);
            i += limit;
        }
        return ans;
    }
}