class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int maxVal = 0;
        for (int i = 0; i < (1 << n); i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    cur |= nums[j];
                }
            }
            if (cur > maxVal) {
                maxVal = cur;
                ans = 1;
            } else if (cur == maxVal) {
                ans++;
            }
        }
        return ans;
    }
};