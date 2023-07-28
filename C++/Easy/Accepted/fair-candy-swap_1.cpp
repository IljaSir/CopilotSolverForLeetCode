class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
        
        int sumA = accumulate(aliceSizes.begin(), aliceSizes.end(), 0);
        int sumB = accumulate(bobSizes.begin(), bobSizes.end(), 0);
        int delta = (sumA - sumB) / 2;
        unordered_set<int> bset(bobSizes.begin(), bobSizes.end());
        for (int a: aliceSizes)
            if (bset.count(a - delta))
                return {a, a - delta};
        return {};
    }
};