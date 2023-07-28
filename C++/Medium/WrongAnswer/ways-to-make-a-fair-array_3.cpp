class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n);
        vector<int> even(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = nums[i];
            } else {
                odd[i] = nums[i];
            }
        }
        for (int i = 1; i < n; i++) {
            even[i] += even[i - 1];
            odd[i] += odd[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int evenSum = even[n - 1] - even[i];
            int oddSum = odd[n - 1] - odd[i];
            if (i > 0) {
                evenSum += even[i - 1];
                oddSum += odd[i - 1];
            }
            if (evenSum == oddSum) {
                ans++;
            }
        }
        return ans;
    }
};