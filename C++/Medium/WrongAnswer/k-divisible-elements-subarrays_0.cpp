class Solution {
public:
    int countDistinct(vector<int>& nums, int k, int p) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                if (nums[j] % p == 0) {
                    ++cnt;
                }
                if (cnt <= k) {
                    ++ans;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
};