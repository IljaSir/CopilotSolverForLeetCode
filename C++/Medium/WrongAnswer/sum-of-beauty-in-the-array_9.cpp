class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> min(n, 0);
        vector<int> max(n, 0);
        int ans = 0;
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = min[i - 1];
            if (nums[i] < min[i]) {
                min[i] = nums[i];
            }
        }
        max[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = max[i + 1];
            if (nums[i] > max[i]) {
                max[i] = nums[i];
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > min[i - 1] && nums[i] < max[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
};