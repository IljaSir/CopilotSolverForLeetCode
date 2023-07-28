class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        sort(properties.begin(), properties.end(), [](vector<int> &a, vector<int> &b) {
            return a[0] > b[0];
        });
        int n = properties.size();
        int maxDefense = properties[0][1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (properties[i][1] < maxDefense) {
                ans++;
            }
            maxDefense = max(maxDefense, properties[i][1]);
        }
        return ans;
    }
};