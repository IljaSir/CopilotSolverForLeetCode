class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size(), sum = 0, odd = 0, even = 0, res = 0;
        vector<int> oddSum(n, 0), evenSum(n, 0);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (i % 2 == 0) {
                even += nums[i];
                evenSum[i] = even;
                oddSum[i] = odd;
            } else {
                odd += nums[i];
                oddSum[i] = odd;
                evenSum[i] = even;
            }
        }
        for (int i = 0; i < n; ++i) {
            int oddSum1 = oddSum[i];
            int evenSum1 = evenSum[i];
            int oddSum2 = odd - oddSum[i];
            int evenSum2 = even - evenSum[i];
            if (oddSum1 + evenSum2 == evenSum1 + oddSum2) {
                ++res;
            }
        }
        return res;
    }
};