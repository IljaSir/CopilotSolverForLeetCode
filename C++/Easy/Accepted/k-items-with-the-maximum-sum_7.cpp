class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int max = 0;
        int sum = 0;
        int c = 0;
        if (numOnes >= k) {
            for (int i = 0; i < k; i++) {
                sum += 1;
            }
            max = sum;
        }
        if (numOnes < k) {
            for (int i = 0; i < numOnes; i++) {
                sum += 1;
            }
            c = k - numOnes;
            if (c <= numZeros) {
                for (int i = 0; i < c; i++) {
                    sum += 0;
                }
                max = sum;
            }
            if (c > numZeros) {
                for (int i = 0; i < numZeros; i++) {
                    sum += 0;
                }
                c = c - numZeros;
                for (int i = 0; i < c; i++) {
                    sum += -1;
                }
                max = sum;
            }
        }
        return max;
    }
};