class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        if (k == 0) {
            return 0;
        }
        if (numOnes == 0) {
            if (numZeros > 0) {
                return 0;
            }
            else {
                return -numNegOnes;
            }
        }
        if (numNegOnes == 0) {
            return numOnes;
        }
        if (k == numOnes + numZeros + numNegOnes) {
            return numOnes - numNegOnes;
        }
        return max(numOnes + kItemsWithMaximumSum(numOnes - 1, numZeros, numNegOnes, k - 1), kItemsWithMaximumSum(numOnes, numZeros, numNegOnes - 1, k));
    }
};