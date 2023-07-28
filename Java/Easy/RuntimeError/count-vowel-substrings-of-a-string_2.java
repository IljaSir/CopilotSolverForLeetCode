class Solution {
    public int countVowelSubstrings(String word) {
        
        int[] dp = new int[5];
        int sum = 0;
        for (char c : word.toCharArray()) {
            dp[c - 'a'] = Arrays.stream(dp).sum() + 1;
            sum += dp[c - 'a'];
        }
        return sum;
    }
}