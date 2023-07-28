class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sumA = accumulate(aliceSizes.begin(), aliceSizes.end(), 0);
        int sumB = accumulate(bobSizes.begin(), bobSizes.end(), 0);
        int diff = (sumA - sumB) / 2;
        unordered_set<int> setA(aliceSizes.begin(), aliceSizes.end());
        for (int b : bobSizes) {
            if (setA.find(b + diff) != setA.end()) {
                return {b + diff, b};
            }
        }
        return {};
    }
};