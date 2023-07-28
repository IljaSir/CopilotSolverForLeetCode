class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int total = mean * (m + n);
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return {};
        }
        vector<int> result(n);
        for (int i = 0; i < n; ++i) {
            result[i] = missing / n;
            missing -= result[i];
            --n;
        }
        for (int i = 0; i < result.size(); ++i) {
            if (result[i] == 0) {
                result[i] = 1;
                --missing;
            }
        }
        for (int i = result.size() - 1; i >= 0 && missing > 0; --i) {
            if (result[i] < 6) {
                ++result[i];
                --missing;
            }
        }
        return result;
    }
};