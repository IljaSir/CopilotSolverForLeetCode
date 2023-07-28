class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sum1 = 0, sum2 = 0;
        for (auto i : aliceSizes) sum1 += i;
        for (auto i : bobSizes) sum2 += i;
        int diff = (sum1 - sum2) / 2;
        unordered_set<int> set;
        for (auto i : aliceSizes) set.insert(i);
        for (auto i : bobSizes) {
            if (set.find(i + diff) != set.end()) {
                return {i + diff, i};
            }
        }
        return {};
    }
};