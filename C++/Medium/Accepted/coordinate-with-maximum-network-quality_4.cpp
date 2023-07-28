class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        vector<int> res{0, 0};
        int ans = 0;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int sum = 0;
                for (auto& t : towers) {
                    int d = (x - t[0]) * (x - t[0]) + (y - t[1]) * (y - t[1]);
                    if (d <= radius * radius) {
                        sum += floor(t[2] / (1.0 + sqrt(d)));
                    }
                }
                if (sum > ans) {
                    ans = sum;
                    res = {x, y};
                }
            }
        }
        return res;
    }
};