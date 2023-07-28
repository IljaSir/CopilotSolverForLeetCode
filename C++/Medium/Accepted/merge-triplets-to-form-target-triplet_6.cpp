class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        
        int x = target[0], y = target[1], z = target[2], a, b, c;
        for (auto& t : triplets) {
            if (t[0] <= x && t[1] <= y && t[2] <= z) {
                a = max(a, t[0]);
                b = max(b, t[1]);
                c = max(c, t[2]);
            }
        }
        return a == x && b == y && c == z;
    }
};