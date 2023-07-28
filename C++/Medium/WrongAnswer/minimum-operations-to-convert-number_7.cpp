class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (start < goal) {
                if (start + nums[i] > goal) {
                    ans += (goal - start) / nums[i];
                    start += (goal - start) / nums[i] * nums[i];
                }
            } else {
                if (start - nums[i] < goal) {
                    ans += (start - goal) / nums[i];
                    start -= (start - goal) / nums[i] * nums[i];
                }
            }
            if (start == goal) break;
        }
        if (start == goal) return ans;
        return -1;
    }
};