class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        
        sort(tokens.begin(), tokens.end());
        int maxScore = 0, score = 0;
        int i = 0, j = tokens.size() - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                maxScore = max(maxScore, ++score);
            } else if (score > 0) {
                power += tokens[j--];
                --score;
            } else {
                break;
            }
        }
        return maxScore;
    }
};