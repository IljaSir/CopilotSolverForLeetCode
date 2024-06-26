class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int n = nums.size();
        if (n == 0) return {-1, -1};
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) return {-1, -1};
        int start = l;
        l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        return {start, l};
    }
};