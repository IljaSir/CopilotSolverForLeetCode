class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int s = mean * (m + n) - sum;
        if (s < n || s > 6 * n) return {};
        vector<int> res(n, 1);
        s -= n;
        for (int i = 0; i < n; ++i) {
            int t = min(5, s);
            res[i] += t;
            s -= t;
        }
        return res;
    }
};