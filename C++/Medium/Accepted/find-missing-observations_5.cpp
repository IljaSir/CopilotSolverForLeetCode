class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int total = (m + n) * mean;
        int missing = total - sum;
        if (missing < n || missing > 6 * n) return {};
        int avg = missing / n;
        int rest = missing % n;
        vector<int> res(n, avg);
        for (int i = 0; i < rest; ++i) {
            res[i] += 1;
        }
        return res;
    }
};