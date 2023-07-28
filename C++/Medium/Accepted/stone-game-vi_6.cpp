class Solution {
public:
    int stoneGameVI(vector<int>& aliceValues, vector<int>& bobValues) {
        
        int n = aliceValues.size();
        vector<pair<int, int>> vals;
        for (int i = 0; i < n; ++i) {
            vals.push_back({aliceValues[i] + bobValues[i], i});
        }
        sort(vals.rbegin(), vals.rend());
        int alice = 0, bob = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                alice += aliceValues[vals[i].second];
            } else {
                bob += bobValues[vals[i].second];
            }
        }
        if (alice == bob) {
            return 0;
        }
        return alice > bob ? 1 : -1;
    }
};