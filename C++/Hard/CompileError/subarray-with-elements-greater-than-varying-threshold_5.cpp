class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isValid(nums, mid, threshold)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return isValid(nums, l, threshold) ? l : -1;
    }
};