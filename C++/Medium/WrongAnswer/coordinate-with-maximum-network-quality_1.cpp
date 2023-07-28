class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        int max = 0;
        vector<int> res;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int sum = 0;
                for (auto tower : towers) {
                    int d = sqrt((x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]));
                    if (d <= radius) {
                        sum += tower[2] / (1 + d);
                    }
                }
                if (sum > max) {
                    max = sum;
                    res = {x, y};
                }
            }
        }
        return res;
    }
};