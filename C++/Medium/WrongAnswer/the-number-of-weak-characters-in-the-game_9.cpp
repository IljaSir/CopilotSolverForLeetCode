class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        int n = properties.size();
        vector<vector<int>> prop = properties;
        sort(prop.begin(), prop.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });
        int ans = 0;
        int maxDef = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (prop[i][1] < maxDef) {
                ans++;
            } else {
                maxDef = prop[i][1];
            }
        }
        return ans;
    }
};