class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(words[i], i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String s = words[i].substring(0, j) + words[i].substring(j + 1);
                if (map.containsKey(s)) {
                    int k = map.get(s);
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}