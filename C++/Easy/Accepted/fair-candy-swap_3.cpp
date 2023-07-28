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
        int target = (sumA - sumB) / 2;
        set<int> setB;
        for (int i = 0; i < bobSizes.size(); i++) {
            setB.insert(bobSizes[i]);
        }
        for (int i = 0; i < aliceSizes.size(); i++) {
            int diff = aliceSizes[i] - target;
            if (setB.find(diff) != setB.end()) {
                return {aliceSizes[i], diff};
            }
        }
        return {};
    }
};