class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < n - 1; ++i) {
            maxPos = max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                ++ans;
            }
        }
        return ans;
    }
};