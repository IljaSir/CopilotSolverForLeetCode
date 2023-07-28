class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        int maxScore = 0;
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                maxScore++;
            } else if (maxScore > 0 && i < j) {
                power += tokens[j--];
                maxScore--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}