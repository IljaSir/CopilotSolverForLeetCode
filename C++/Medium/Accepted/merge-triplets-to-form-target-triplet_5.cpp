class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        
        int x = target[0], y = target[1], z = target[2];
        int x1 = 0, y1 = 0, z1 = 0;
        for (auto &v : triplets) {
            if (v[0] <= x && v[1] <= y && v[2] <= z) {
                x1 = max(x1, v[0]);
                y1 = max(y1, v[1]);
                z1 = max(z1, v[2]);
            }
        }
        return x1 == x && y1 == y && z1 == z;
    }
};