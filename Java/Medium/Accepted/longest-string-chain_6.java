class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() > 1) {
                    continue;
                }
                if (isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private boolean isPredecessor(String a, String b) {
        if (a.length() != b.length() + 1) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.substring(0, i).equals(b.substring(0, i)) && a.substring(i + 1).equals(b.substring(i))) {
                return true;
            }
        }
        return false;
    }
}