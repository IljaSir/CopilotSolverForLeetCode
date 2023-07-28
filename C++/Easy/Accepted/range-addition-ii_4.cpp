class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        
        int minr = m, minc = n;
        for (auto &op : ops) {
            minr = min(minr, op[0]);
            minc = min(minc, op[1]);
        }
        return minr * minc;
    }
};