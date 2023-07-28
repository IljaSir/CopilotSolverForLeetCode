class Solution {
public:
    bool search(vector<int>& nums, int target) {
        
        int n = nums.size();
        if (n == 0) return false;
        if (n == 1) return nums[0] == target;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[l]) {
                l++;
                continue;
            }
            if (nums[mid] > nums[l]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
};