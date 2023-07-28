class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (auto x : aliceSizes) sum1 += x;
        for (auto x : bobSizes) sum2 += x;
        int diff = (sum1 - sum2) / 2;
        set<int> s;
        for (auto x : aliceSizes) s.insert(x);
        for (auto y : bobSizes) {
            if (s.find(y + diff) != s.end()) {
                return {y + diff, y};
            }
        }
        return {};
    }
};