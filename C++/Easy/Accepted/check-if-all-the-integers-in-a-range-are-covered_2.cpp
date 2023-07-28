class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> cover(52, 0);
        for (auto& r : ranges) {
            cover[r[0]]++;
            cover[r[1] + 1]--;
        }
        for (int i = 1; i <= 50; i++) {
            cover[i] += cover[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (cover[i] == 0) {
                return false;
            }
        }
        return true;
    }
};