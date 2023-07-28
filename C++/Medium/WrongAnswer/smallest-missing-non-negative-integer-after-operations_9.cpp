class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int i = 0;
        int mx = 0;
        while (i < n && nums[i] < 0) {
            int j = i;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            int cur = nums[i] + (j - i) * value;
            if (cur >= 0) {
                break;
            }
            mx = max(mx, j - i);
            i = j;
        }
        int ans = mx;
        for (int j = i; j < n; j++) {
            if (nums[j] - nums[i] > value * (j - i)) {
                ans = max(ans, j - i);
            }
        }
        return ans + 1;
    }
};