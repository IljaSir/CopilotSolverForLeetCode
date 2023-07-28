class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int start = 0;
        int end = 0;
        while (end < n - 1) {
            ans++;
            int maxend = end + 1;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] >= n - 1) {
                    return ans;
                }
                maxend = max(maxend, i + nums[i]);
            }
            start = end + 1;
            end = maxend;
        }
        return ans;
    }
};