class Solution {
public:
    int stoneGameVI(vector<int>& aliceValues, vector<int>& bobValues) {
        
        int n = aliceValues.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; i++) {
            v.push_back({aliceValues[i] + bobValues[i], i});
        }
        sort(v.rbegin(), v.rend());
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[v[i].second];
            } else {
                bob += bobValues[v[i].second];
            }
        }
        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        } else {
            return 0;
        }
    }
};