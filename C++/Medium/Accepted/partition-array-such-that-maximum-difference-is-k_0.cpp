class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1;
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && nums[r] - nums[l] <= k) {
                r++;
            }
            if (r == n) {
                break;
            }
            ans++;
            l = r;
        }
        return ans;
    }
};