class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int sum = 0;
        for (int i = 0; i < rolls.size(); i++) {
            sum += rolls[i];
        }
        int all = (sum + mean * (n + rolls.size())) / (n + rolls.size());
        int missing = all * n - sum;
        if (missing < n || missing > 6 * n) {
            return {};
        }
        vector<int> res(n, all);
        missing -= n;
        for (int i = 0; i < n; i++) {
            int add = min(5, missing);
            res[i] += add;
            missing -= add;
        }
        return res;
    }
};