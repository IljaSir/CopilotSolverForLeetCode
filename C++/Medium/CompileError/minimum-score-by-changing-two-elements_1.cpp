class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int minVal = nums[0], maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            minVal = min(minVal, nums[i]);
            maxVal = max(maxVal, nums[i]);
        }
        int low = 0, high = maxVal - minVal;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    bool check(vector<int>& nums, int mid) {
        int n = nums.size();
        int maxVal = nums[0], minVal = nums[0];
        for (int i = 1; i < n; i++) {
            maxVal = max(maxVal, nums[i]);
            minVal = min(minVal, nums[i]);
            if (maxVal - minVal > mid) {
                return false;
            }
        }
        return true;
    }
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int ans = INT_MAX;
        for (int i = 0; i < 4; i++) {
            ans = min(ans, nums[nums.size() - 4 + i] - nums[i]);
        }
        return ans;
    }
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int ans = INT_MAX;
        for (int i = 0; i < 4; i++) {
            ans = min(ans, nums[nums.size() - 4 + i] - nums[i]);
        }
        return ans;
    }
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int ans = INT_MAX;
        for (int i = 0; i < 4; i++) {
            ans = min(ans, nums[nums.size() - 4 + i] - nums[i]);
        }
        return
    }
};