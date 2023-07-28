class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = nums.size();
        int m = numSlots;
        int maxSum = 0;
        for (int i = 0; i < n; ++i) {
            int sum = nums[i];
            for (int j= i + ; j < n; ++j) {
                sum &= nums[j;
                if (sum == 0) {
                    break;
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                cur &= nums[j];
                if (j - i + 1 == numSlots) {
                    ans = max(ans, cur);
                    break;
                }
            }
        }
        return ans;
    }
};