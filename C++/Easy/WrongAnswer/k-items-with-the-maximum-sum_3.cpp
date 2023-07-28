class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int ans = 0;
        for(int i = 0; i <= k; i++){
            int j = k - i;
            if(i > numOnes || j > numZeros + numNegOnes) continue;
            ans = max(ans, min(numOnes, i) + min(numZeros, j) - min(numNegOnes, j));
        }
        return ans;
    }
};