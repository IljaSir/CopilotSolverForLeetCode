class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> c(52, 0);
        for (auto &r : ranges) {
            for (int i = r[0]; i <= r[1]; ++i) {
                c[i]++;
            }
        }
        for (int i = left; i <= right; ++i) {
            if (c[i] == 0) return false;
        }
        return true;
    }
};