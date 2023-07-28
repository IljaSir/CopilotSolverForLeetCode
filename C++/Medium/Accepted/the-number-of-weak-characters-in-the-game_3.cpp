class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        int n = properties.size();
        sort(properties.begin(), properties.end(), [](auto& a, auto& b) {
            return a[0] == b[0] ? a[1] > b[1] : a[0] < b[0];
        });
        int ans = 0, max_def = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (properties[i][1] < max_def) ++ans;
            max_def = max(max_def, properties[i][1]);
        }
        return ans;
    }
};