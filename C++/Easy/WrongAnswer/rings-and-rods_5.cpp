class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.size() / 2;
        vector<vector<int>> colors(10);
        for (int i = 0; i < n; ++i) {
            colors[rings[i * 2 + 1] - '0'].push_back(rings[i * 2] - 'A');
        }
        int res = 0;
        for (auto& color : colors) {
            if (color.size() >= 3) {
                sort(color.begin(), color.end());
                for (int i = 0; i < color.size() - 2; ++i) {
                    if (color[i + 2] - color[i] <= 2) {
                        ++res;
                        break;
                    }
                }
            }
        }
        return res;
    }
};