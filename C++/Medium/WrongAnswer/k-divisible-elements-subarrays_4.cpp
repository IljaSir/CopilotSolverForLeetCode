class Solution {
public:
    int countDistinct(vector<int>& nums, int k, int p) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            int j = i;
            while (j < n && cnt <= k) {
                if (nums[j] % p == 0) {
                    ++cnt;
                }
                if (cnt <= k) {
                    ++ans;
                }
                ++j;
            }
        }
        return ans;
    }
};