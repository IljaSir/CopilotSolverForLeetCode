class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        vector<int> result;
        int maxQuality = 0;
        for (int x = 0; x <= 50; ++x) {
            for (int y = 0; y <= 50; ++y) {
                int quality = 0;
                for (auto& tower : towers) {
                    int distance = sqrt((x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]));
                    if (distance <= radius) {
                        quality += tower[2] / (1 + distance);
                    }
                }
                if (quality > maxQuality) {
                    maxQuality = quality;
                    result = {x, y};
                } else if (quality == maxQuality) {
                    if (result.empty() || x < result[0] || (x == result[0] && y < result[1])) {
                        result = {x, y};
                    }
                }
            }
        }
        return result;
    }
};