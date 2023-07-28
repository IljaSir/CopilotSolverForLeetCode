class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        int odd[n];
        int even[n];
        odd[0] = nums[0];
        even[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = even[i - 1] + nums[i];
                odd[i] = odd[i - 1];
            } else {
                odd[i] = odd[i - 1] + nums[i];
                even[i] = even[i - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum1 = 0;
            int sum2 = 0;
            if (i > 0) {
                sum1 += odd[i - 1];
                sum2 += even[i - 1];
            }
            if (i < n - 1) {
                sum1 += even[n - 1] - even[i];
                sum2 += odd[n - 1] - odd[i];
            }
            if (sum1 == sum2) {
                res++;
            }
        }
        return res;
    }
};