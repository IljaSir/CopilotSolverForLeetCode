class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() == words[j].length() + 1 && isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res + 1;
    }
    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == a.length();
    }
}