class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        
        sort(tokens.begin(), tokens.end());
        int left = 0, right = tokens.size() - 1;
        int score = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
            } else if (score > 0 && right > left) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }
        return score;
    }
};