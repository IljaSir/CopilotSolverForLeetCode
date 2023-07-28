class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        sort(properties.begin(), properties.end(), [](auto& a, auto& b) {
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        int n = properties.size();
        int maxDef = INT_MIN;
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            if (properties[i][1] < maxDef) {
                ++ret;
            }
            maxDef = max(maxDef, properties[i][1]);
        }
        return ret;
    }
};