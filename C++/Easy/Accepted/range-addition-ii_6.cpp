class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        
        int min_i = m;
        int min_j = n;
        for (auto& op : ops) {
            min_i = min(min_i, op[0]);
            min_j = min(min_j, op[1]);
        }
        return min_i * min_j;
    }
};