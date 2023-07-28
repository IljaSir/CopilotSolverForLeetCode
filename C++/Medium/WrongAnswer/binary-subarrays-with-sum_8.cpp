class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int l = 0, r = 0, n = nums.size(), sum = 0, res = 0;
        while (r < n) {
            sum += nums[r];
            while (l <= r && sum > goal) {
                sum -= nums[l];
                l++;
            }
            if (sum == goal) {
                int r2 = r + 1;
                while (r2 < n && nums[r2] == 0) r2++;
                int l2 = l;
                while (l2 > 0 && nums[l2 - 1] == 0) l2--;
                res += (r2 - r) * (l - l2 + 1);
                l = l2;
            }
            r++;
        }
        return res;
    }
};