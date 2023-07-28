class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        sort(properties.begin(), properties.end(), [](auto &a, auto &b) {
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        int ans = 0;
        int max_d = 0;
        for (int i = 0; i < properties.size(); ++i) {
            if (i == 0 || properties[i][0] == properties[i - 1][0]) {
                max_d = max(max_d, properties[i][1]);
            } else {
                if (properties[i][1] < max_d) {
                    ans++;
                }
            }
        }
        return ans;
    }
};