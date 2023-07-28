class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                int ones = min(numOnes, j);
                int zeros = min(numZeros, i - j);
                int negOnes = min(numNegOnes, k - i);
                int tmp = ones - negOnes;
                if (tmp > 0) {
                    sum += tmp * zeros;
                }
            }
            res = max(res, sum);
        }
        return res;
    }
};