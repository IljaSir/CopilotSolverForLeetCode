class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        
        int n = tokens.size();
        int res = 0;
        sort(tokens.begin(), tokens.end());
        int l = 0, r = n - 1;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l++];
                res++;
            }
            else if (res > 0 && l < r) {
                power += tokens[r--];
                res--;
            }
            else
                break;
        }
        return res;
    }
};