class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                ans++;
                if (i + 1 < n && nums[i + 1] % 2 == 1) {
                    i++;
                }
            }
        }
        return ans;
    }
};