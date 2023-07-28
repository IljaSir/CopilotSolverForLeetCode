class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> res;
        if (nums.size() == 0) {
            resl < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums.size() == 0 || nums[l] != target) return res;
        res[0] = l;
        r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        res[1] = r;
        return res;
    }
};