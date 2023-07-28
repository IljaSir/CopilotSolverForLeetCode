class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int sum = 0;
        int zero = min(numZeros, k);
        for (int i = 0; i <= zero; i++) {
            int one = min(numOnes, k - i);
            int negOne = min(numNegOnes, k - i - one);
            sum = max(sum, i + one + negOne);
        }
        return sum;
    }
};