class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        int n = ranges.size();
        vector<int> v(52, 0);
        for (int i = 0; i < n; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                v[j]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (v[i] == 0) {
                return false;
            }
        }
        return true;
    }
};