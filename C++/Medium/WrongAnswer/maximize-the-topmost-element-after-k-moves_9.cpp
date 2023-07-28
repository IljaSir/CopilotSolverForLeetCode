class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = -1;
        for (int i = 0; i < n; ++ i) {
            int t = nums[i];
            int r = n - i - 1;
            int c = nums[i] + min(k, r);
            ans = max(ans, c);
        }
        return ans;
    }
};