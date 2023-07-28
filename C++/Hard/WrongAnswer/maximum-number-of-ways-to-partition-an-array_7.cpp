class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int ans = 0;
        int cur = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == k) ++cnt;
            cur += nums[i];
            if (cur == sum - cur) ++ans;
        }
        if (cnt == 0) {
            ans = 0;
            cur = 0;
            for (int i = 0; i < n; ++i) {
                cur += nums[i];
                if (cur == sum - cur + k) ++ans;
            }
        }
        return ans;
    }
};