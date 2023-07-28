class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int total = 0;
        int m = rolls.size();
        for (auto roll : rolls) {
            total += roll;
        }
        int missingTotal = (mean * (m + n)) - total;
        if (missingTotal < n || missingTotal > 6 * n) {
            return {};
        }
        vector<int> result;
        int missingCount = n;
        while (missingCount > 0) {
            int missing = missingTotal / missingCount;
            if (missing > 6) {
                missing = 6;
            }
            result.push_back(missing);
            missingTotal -= missing;
            missingCount--;
        }
        return result;
    }
};