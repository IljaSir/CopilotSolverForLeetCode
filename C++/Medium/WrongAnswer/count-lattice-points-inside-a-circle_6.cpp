class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int ans = 0;
        for (auto& c : circles) {
            int x = c[0], y = c[1], r = c[2];
            for (int i = x-r; i <= x+r; ++i) {
                int dx = i-x, dy = sqrt(r*r-dx*dx);
                ans += 2*dy+1;
            }
        }
        return ans;
    }
};