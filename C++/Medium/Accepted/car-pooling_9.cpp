class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        int max = 0;
        for (auto &trip : trips) {
            if (max < trip[2]) {
                max = trip[2];
            }
        }
        vector<int> v(max + 1, 0);
        for (auto &trip : trips) {
            v[trip[1]] += trip[0];
            v[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
};