class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n, 0);
        vector<int> even(n, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                odd[i] = nums[i];
                even[i] = nums[i] - 1;
            } else {
                odd[i] = nums[i] - 1;
                even[i] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (odd[i] <= odd[i+1]) {
                    res += odd[i+1] - odd[i] + 1;
                    odd[i+1] = odd[i] - 1;
                }
            } else if (i == n - 1) {
                if (odd[i] <= odd[i-1]) {
                    res += odd[i-1] - odd[i] + 1;
                    odd[i-1] = odd[i] - 1;
                }
            } else {
                if (odd[i] <= odd[i-1]) {
                    res += odd[i-1] - odd[i] + 1;
                    odd[i-1] = odd[i] - 1;
                }
                if (odd[i] <= odd[i+1]) {
                    res += odd[i+1] - odd[i] + 1;
                    odd[i+1] = odd[i] - 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (even[i] <= even[i+1]) {
                    res += even[i+1] - even[i] + 1;
                    even[i+1] = even[i] - 1;
                }
            } else if (i == n - 1) {
                if (even[i] <= even[i-1]) {
                    res += even[i-1] - even[i] + 1;
                    even[i-1] = even[i] - 1;
                }
            } else {
                if (even[i] <= even[i-1]) {
                    res += even[i-1] - even[i] + 1;
                    even
    }
};