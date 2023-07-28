class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        
        int r = 0, g = 0, b = 0;
        for (auto& t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                r = max(r, t[0]);
                g = max(g, t[1]);
                b = max(b, t[2]);
            }
        }
        return r == target[0] && g == target[1] && b == target[2];
    }
};