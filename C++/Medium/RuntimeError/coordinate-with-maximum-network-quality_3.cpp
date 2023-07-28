class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        int max_quality = 0;
        vector<int> result;
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= 50; ++j) {
                int quality = 0;
                for (int k = 0; k < towers.size(); ++k) {
                    int distance = pow(i - towers[k][0], 2) + pow(j - towers[k][1], 2);
                    if (distance <= pow(radius, 2)) {
                        quality += towers[k][2] / (1 + sqrt(distance));
                    }
                }
                if (quality > max_quality) {
                    max_quality = quality;
                    result = {i, j};
                } else if (quality == max_quality) {
                    if (i < result[0] || (i == result[0] && j < result[1])) {
                        result = {i, j};
                    }
                }
            }
        }
        return result;
    }
};