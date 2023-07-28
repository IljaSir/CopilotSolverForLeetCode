class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int N = nums.size();
        int M = 1e9 + 7;
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int l = i, r = N - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] + nums[i] < k) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (nums[l] + nums[i] < k) {
                continue;
            }
            ans = (ans + (1 << (N - l - 1))) % M;
        }
        return ans;
    }
};