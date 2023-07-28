class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sumA = 0;
        int sumB = 0;
        int diff = 0;
        for (int i = 0; i < aliceSizes.size(); i++)
            sumA += aliceSizes[i];
        for (int i = 0; i < bobSizes.size(); i++)
            sumB += bobSizes[i];
        diff = (sumA - sumB) / 2;
        for (int i = 0; i < aliceSizes.size(); i++) {
            for (int j = 0; j < bobSizes.size(); j++) {
                if (aliceSizes[i] - bobSizes[j] == diff) {
                    return {aliceSizes[i], bobSizes[j]};
                }
            }
        }
        return {};
    }
};