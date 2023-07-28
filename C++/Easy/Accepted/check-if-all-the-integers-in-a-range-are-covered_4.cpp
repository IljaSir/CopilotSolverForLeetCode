class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        int n = ranges.size();
        vector<bool> covered(52, false);
        for (int i = 0; i < n; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                covered[j] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!covered[i]) return false;
        }
        return true;
    }
};