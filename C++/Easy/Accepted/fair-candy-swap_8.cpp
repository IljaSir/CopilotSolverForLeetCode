class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sumA = 0, sumB = 0;
        for (auto& i : aliceSizes) sumA += i;
        for (auto& i : bobSizes) sumB += i;
        int diff = (sumA - sumB) / 2;
        unordered_set<int> s;
        for (auto& i : aliceSizes) s.insert(i);
        for (auto& i : bobSizes) {
            if (s.count(i + diff)) {
                return {i + diff, i};
            }
        }
        return {};
    }
};