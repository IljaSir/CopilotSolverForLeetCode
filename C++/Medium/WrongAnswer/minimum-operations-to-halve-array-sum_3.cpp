class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum / 2;
        if (sum % 2 == 0) {
            target--;
        }
        sort(nums.begin(), nums.end());
        int ans = 0;
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            ans++;
            if (cur > target) {
                break;
            }
        }
        return ans;
    }
};