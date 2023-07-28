class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int sum = 0;
        for (int i = 0; i < rolls.size(); i++) {
            sum += rolls[i];
        }
        int total = mean * (n + rolls.size());
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return {};
        }
        int avg = missing / n;
        int remainder = missing % n;
        vector<int> ret;
        for (int i = 0; i < n; i++) {
            ret.push_back(avg + (i < remainder ? 1 : 0));
        }
        return ret;
    }
};