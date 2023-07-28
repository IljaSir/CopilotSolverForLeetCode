class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> covered(52, 0);
        for (auto v : ranges) {
            for (int i = v[0]; i <= v[1]; ++i) {
                covered[i] = 1;
            }
        }
        for (int i = left; i <= right; ++i) {
            if (covered[i] == 0) {
                return false;
            }
        }
        return true;
    }
};