class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        sort(properties.begin(), properties.end(), [](auto& a, auto& b) {
            return a[0] == b[0] ? a[1] > b[1] : a[0] < b[0];
        });
        int res = 0, maxd = 0;
        for (int i = properties.size() - 1; i >= 0; --i) {
            if (properties[i][1] < maxd) ++res;
            maxd = max(maxd, properties[i][1]);
        }
        return res;
    }
};