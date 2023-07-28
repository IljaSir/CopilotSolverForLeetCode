class Solution {
public:
    int stoneGameVI(vector<int>& aliceValues, vector<int>& bobValues) {
        
        int n = aliceValues.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.push_back({aliceValues[i] + bobValues[i], i});
        }
        sort(v.begin(), v.end(), greater<pair<int, int>>());
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (i & 1) {
                b += bobValues[v[i].second];
            } else {
                a += aliceValues[v[i].second];
            }
        }
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }
};