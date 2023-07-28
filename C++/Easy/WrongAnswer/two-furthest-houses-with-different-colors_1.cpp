class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < colors.size(); i++) {
            if (m.count(colors[i]) > 0) {
                res = max(res, i - m[colors[i]]);
            }
            m[colors[i]] = i;
        }
        return res;
    }
};