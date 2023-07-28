class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        vector<int> res;
        int max = 0;
        for (int i = 0; i < 51; ++i) {
            for (int j = 0; j < 51; ++j) {
                int sum = 0;
                for (auto& t : towers) {
                    int d = sqrt(pow(i - t[0], 2) + pow(j - t[1], 2));
                    if (d <= radius) {
                        sum += t[2] / (1 + d);
                    }
                }
                if (sum > max) {
                    max = sum;
                    res = {i, j};
                }
            }
        }
        return res;
    }
};