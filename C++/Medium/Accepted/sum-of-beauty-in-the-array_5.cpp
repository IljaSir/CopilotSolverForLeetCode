class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> maxLeft(n);
        vector<int> minRight(n);
        maxLeft[0] = nums[0];
        minRight[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = max(maxLeft[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = min(minRight[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxLeft[i - 1] && nums[i] < minRight[i + 1]) {
                ans += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
};