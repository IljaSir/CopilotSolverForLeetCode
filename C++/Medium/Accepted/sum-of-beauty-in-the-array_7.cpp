class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int maxl[n];
        int minr[n];
        maxl[0] = nums[0];
        minr[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            maxl[i] = max(maxl[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            minr[i] = min(minr[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] > maxl[i - 1] && nums[i] < minr[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
};