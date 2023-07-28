class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        sort(properties.begin(), properties.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0] || a[0] == b[0] && a[1] > b[1];
        });
        int res = 0, cur = 0;
        for (int i = properties.size() - 1; i >= 0; --i) {
            if (properties[i][1] < cur) ++res;
            cur = max(cur, properties[i][1]);
        }
        return res;
    }
};