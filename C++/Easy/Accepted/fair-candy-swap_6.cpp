class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sum_alice = 0, sum_bob = 0;
        for (int i = 0; i < aliceSizes.size(); i++)
            sum_alice += aliceSizes[i];
        for (int j = 0; j < bobSizes.size(); j++)
            sum_bob += bobSizes[j];
        int delta = (sum_alice - sum_bob) / 2;
        for (int i = 0; i < aliceSizes.size(); i++) {
            for (int j = 0; j < bobSizes.size(); j++) {
                if (aliceSizes[i] - bobSizes[j] == delta) {
                    return {aliceSizes[i], bobSizes[j]};
                }
            }
        }
        return {};
    }
};