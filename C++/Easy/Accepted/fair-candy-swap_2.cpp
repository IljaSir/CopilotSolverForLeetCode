class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sumA = 0, sumB = 0;
        for (int i = 0; i < aliceSizes.size(); i++) {
            sumA += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.size(); i++) {
            sumB += bobSizes[i];
        }
        int diff = (sumA - sumB) / 2;
        unordered_set<int> setA;
        for (int i = 0; i < aliceSizes.size(); i++) {
            setA.insert(aliceSizes[i]);
        }
        for (int i = 0; i < bobSizes.size(); i++) {
            if (setA.count(bobSizes[i] + diff)) {
                return {bobSizes[i] + diff, bobSizes[i]};
            }
        }
        return {};
    }
};