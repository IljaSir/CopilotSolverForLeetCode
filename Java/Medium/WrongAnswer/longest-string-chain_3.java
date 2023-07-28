class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() > 1) {
                    continue;
                }
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else if (i != j) {
                return false;
            } else {
                j++;
            }
        }
        return true;
    }
}