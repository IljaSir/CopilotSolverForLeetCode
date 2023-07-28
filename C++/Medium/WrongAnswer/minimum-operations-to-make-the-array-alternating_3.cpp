class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 == 0) {
                    even++;
                }
            } else {
                if (nums[i] % 2 != 0) {
                    odd++;
                }
            }
        }
        int ans = min(even, odd);
        even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 != 0) {
                    even++;
                }
            } else {
                if (nums[i] % 2 == 0) {
                    odd++;
                }
            }
        }
        ans += min(even, odd);
        return ans;
    }
};