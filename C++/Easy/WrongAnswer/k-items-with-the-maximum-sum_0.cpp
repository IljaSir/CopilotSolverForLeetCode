class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int res = 0;
        if (k <= numOnes + numZeros) {
            res = k;
        } else if (k <= numOnes + numZeros + numNegOnes) {
            res = numOnes + (k - numOnes);
        } else {
            res = numOnes + numZeros;
        }
        return res;
    }
};